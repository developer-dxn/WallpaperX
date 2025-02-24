package com.dxn.wallpaperx.ui.anim

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavBackStackEntry
import com.dxn.wallpaperx.ui.navigation.HomeScreen

object CollectionsAnimations {
    fun enterTransition(initial: NavBackStackEntry): EnterTransition {
        return when (initial.destination.route) {
            HomeScreen.Wallpapers.route -> {
                slideInHorizontally(initialOffsetX = { 1000 })
            }
            HomeScreen.Setting.route,HomeScreen.Favourites.route -> {
                slideInHorizontally(initialOffsetX = { -1000 })
            }
            else -> {
                slideInHorizontally()
            }
        }
    }

    fun exitTransition(target: NavBackStackEntry): ExitTransition {
        return when (target.destination.route) {
            HomeScreen.Wallpapers.route -> {
                slideOutHorizontally(targetOffsetX = { 1000 })
            }
            HomeScreen.Setting.route,HomeScreen.Favourites.route -> {
                slideOutHorizontally(targetOffsetX = { -1000 })
            }
            else -> {
                slideOutHorizontally(targetOffsetX = { -1000 })
            }
        }
    }
}