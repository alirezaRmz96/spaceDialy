package com.example.spacedaily.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.spacedaily.R

@NonRestartableComposable
@Composable
fun ImagePlaceHolder(
    modifier: Modifier = Modifier,
    @DrawableRes painterResId: Int = R.drawable.ic_app,
    contentDescription: String? = null,
    tint: Color = Color.Gray.copy(alpha = 0.2f)
) {
    Icon(
        modifier = modifier,
        painter = painterResource(painterResId),
        contentDescription = contentDescription,
        tint = tint
    )
}