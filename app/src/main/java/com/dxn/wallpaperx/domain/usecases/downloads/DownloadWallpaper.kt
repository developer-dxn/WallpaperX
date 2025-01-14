package com.dxn.wallpaperx.domain.usecases.downloads

import android.content.Context
import android.net.Uri
import android.util.Log
import com.dxn.wallpaperx.common.extensions.getBitmap
import com.dxn.wallpaperx.domain.models.Wallpaper
import com.dxn.wallpaperx.domain.repositories.WallpaperRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DownloadWallpaper
@Inject
constructor(
    private val repository: WallpaperRepository,
    @ApplicationContext private val context: Context
) {
    suspend operator fun invoke(wallpaper: Wallpaper): Result<Uri?> {
        return try {
            val bitmap = context.getBitmap(wallpaper.wallpaperUrl)
            val uri = repository.downloadWallpaper(bitmap, "IMG${wallpaper.id}.jpg")
            Result.success(uri)
        } catch (e: Exception) {
            Log.e(TAG, "invoke: ${e.message}")
            Result.failure(e)
        }
    }

    companion object {
        const val TAG = "DownloadWallpaper"
    }
}