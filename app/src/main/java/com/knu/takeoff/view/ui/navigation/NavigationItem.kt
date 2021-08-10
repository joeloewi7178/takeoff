package com.knu.takeoff.view.ui.navigation

import com.knu.takeoff.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Feed : NavigationItem("feed", R.drawable.ic_baseline_dynamic_feed_24, "Feed")
    object Calendar : NavigationItem("calendar", R.drawable.ic_baseline_calendar_today_24, "Calendar")
    object Chat : NavigationItem("chat", R.drawable.ic_baseline_chat_24, "Chat")
    object Person : NavigationItem("person", R.drawable.ic_baseline_person_24, "Person")
}
