package me.foji.anko

import java.io.File
import java.io.IOException

/**
 * 统计当前文件夹下面所有子文件大小总和，如果指定文件是不是文件夹，则直接返回当前文件大小
 *
 * @param onCalculating        计算中
 * @param onCalculateCompleted 计算完成
 * @return Folder Size
 */
fun File.folderSize(onCalculating: ((Long)->Unit)? = null ,
                    onCalculateCompleted: ((Long)->Unit)? = null) {
    if(isDirectory) {
        val sum = totalSizeInFolder(this , onCalculating)
        onCalculateCompleted?.invoke(sum)
    } else {
        onCalculateCompleted?.invoke(0)
    }
}

/**
 * 删除当前文件夹下面所有子文件以及文件夹
 *
 * @param withDir           是否包含目录
 * @param withSelft         是否包含当前目录
 * @param onDeleteCompleted 删除完成回调
 * @param onDeleteFailed    删除失败回调
 *
 * @return true 全部删除成功 false 删除失败或者部分删除失败
 */
fun File.deleteFilesInFolder(withDir: Boolean = false ,
                             withSelf: Boolean = false ,
                             onDeleteCompleted: ((File)->Unit)? = null ,
                             onDeleteFailed: ((File , String)->Unit)? = null) {
    try {
        if(me.foji.anko.deleteFilesInFolder(this , withDir , withSelf )) {
            onDeleteCompleted?.invoke(this)
        } else {
            onDeleteFailed?.invoke(this , "")
        }
    } catch (e: IOException) {
        onDeleteFailed?.invoke(this , "${e.message}")
    }
}

/**
 * 创建文件及其目录
 */
@Throws(IOException::class)
fun File.createFileWithDir() {
    if(isDirectory) {
        mkdirs()
    } else {
        val parentFile = parentFile
        if(!parentFile.exists()) {
            if (parentFile.mkdirs()) {
                createNewFile()
            }
        } else {
            createNewFile()
        }
    }
}

private fun totalSizeInFolder(file: File ,
                              onCalculating: ((Long)->Unit)? = null): Long {
    val files = file.listFiles()

    var sum = 0L
    if (null != files && files.isNotEmpty()) {
        for (currFile in files) {
            if(currFile.isDirectory) {
                sum += totalSizeInFolder(currFile)
            } else {
                sum += currFile.length()
            }

            onCalculating?.invoke(sum)
        }
    }

    return sum
}

@Throws(IOException::class)
private fun deleteFilesInFolder(file: File ,
                                withDir: Boolean = false ,
                                withSelf: Boolean = false): Boolean {
    if(!withSelf) {
        val files = file.listFiles()

        if (null != files && files.isNotEmpty()) {
            for (currFile in files) {
                if (withDir) {
                    if(!currFile.deleteRecursively()) {
                        return false
                    }
                } else {
                    if (currFile.isDirectory) {
                        deleteFilesInFolder(currFile)
                    } else {
                        if(!currFile.delete()) {
                            return false
                        }
                    }
                }
            }
        }

        return true
    } else {
        return file.deleteRecursively()
    }
}