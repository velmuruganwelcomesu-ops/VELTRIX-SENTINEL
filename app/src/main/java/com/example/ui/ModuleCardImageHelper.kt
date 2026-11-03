package com.example.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

object ModuleCardImageHelper {
    fun getModuleImageResId(title: String): Int {
        return when (title) {
            "Findings" -> 0x7f080088 // img_daily_ppe (workplace safety inspection / hazard identification)
            "Incidents" -> 0x7f080084 // img_daily_health (incident investigation & safety)
            "Trainings" -> 0x7f08008a // img_daily_training (employees attending safety training)
            "Statutory Compliance" -> 0x7f08007c // img_daily_compliance (compliance documentation)
            "Fire Equipment" -> 0x7f080081 // img_daily_fire (fire extinguishers & protection)
            "AMC Tracker" -> 0x7f080082 // img_daily_generator (maintenance technician inspecting equipment)
            "Materials & Services" -> 0x7f080079 // img_daily_chemical (industrial materials & supplies)
            "Task Scheduler" -> 0x7f080087 // img_daily_observance (professional planning & task management)
            "User Access" -> 0x7f08007d // img_daily_diversity (secure user authentication & access)
            "Unit Personnel" -> 0x7f08007b // img_daily_community (factory personnel & safety team)
            "Benchmarking" -> 0x7f08007f // img_daily_energy (performance measurement & charts)
            "ESG Calendar" -> 0x7f08007a // img_daily_climate (sustainability planning & environmental activities)
            "Due Dashboard" -> 0x7f080077 // img_daily_air (deadlines & compliance monitoring)
            "EHS Governance" -> 0x7f080083 // img_daily_governance (safety leadership & workplace governance)
            "Reports" -> 0x7f080089 // img_daily_reporting (professional EHS reports & data analysis)
            "Alerts" -> 0x7f08008b // img_daily_transport (workplace notifications & safety warnings)
            "Settings" -> 0x7f08008c // img_daily_waste (professional system configuration)
            "Support & Queries" -> 0x7f080080 // img_daily_ergonomics
            else -> 0x7f080088
        }
    }

    @Composable
    fun RenderModuleBackground(title: String, modifier: Modifier = Modifier) {
        val resId = getModuleImageResId(title)
        Image(
            painter = painterResource(id = resId),
            contentDescription = null,
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // Subtle dark overlay to ensure text and glossy icons pop cleanly
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0x99180208), // dark wine overlay at top (60% alpha)
                            Color(0xEE2A020C)  // deep crimson overlay at bottom (93% alpha)
                        )
                    )
                )
        )
    }
}
