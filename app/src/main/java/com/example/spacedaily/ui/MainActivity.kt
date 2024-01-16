package com.example.spacedaily.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import coil.compose.SubcomposeAsyncImage
import com.example.spacedaily.data.PhotoResponse
import com.example.spacedaily.ui.component.ImagePlaceHolder
import com.example.spacedaily.ui.theme.SpaceDailyTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm = koinViewModel<MainViewModel>()

            SpaceDailyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpaceDaily(
                        "Android",
                        vm = vm
                    )
                }
            }
        }
    }
}


@Composable
fun SpaceDaily(
    name: String,
    modifier: Modifier = Modifier,
    vm: MainViewModel = koinViewModel()
) {
    val photoDaily: PhotoResponse by vm.dailyPhotos.collectAsState()
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = photoDaily.title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontStyle = FontStyle.Normal
            )
        )
        SubcomposeAsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)),
            model = photoDaily.url,
            contentDescription = "noting now",
            loading = {
                ImagePlaceHolder()
            }
        )
        Text(
            text = photoDaily.explanation,
            style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontStyle = FontStyle.Italic
            )
        )

        Text(
            text = photoDaily.date,
            style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }

}

@Preview(showBackground = true)
@Composable
fun SpaceDailyPreview() {
    SpaceDailyTheme {
        SpaceDaily("Android")
    }
}