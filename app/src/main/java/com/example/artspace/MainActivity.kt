package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    var currentArt by remember {
        mutableIntStateOf(0)
    }

    val images = listOf(
        R.drawable.mona_lisa,
        R.drawable.starry_night,
        R.drawable.the_scream
    )

    val titles = listOf(
        "Mona Lisa",
        "The Starry Night",
        "The Scream"
    )

    val artists = listOf(
        "Leonardo da Vinci, 1503",
        "Vincent van Gogh, 1889",
        "Edvard Munch, 1893"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(
                id = images[currentArt]
            ),
            contentDescription = titles[currentArt],
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Text(
            text = titles[currentArt],
            fontSize = 28.sp
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = artists[currentArt],
            fontSize = 18.sp
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(
                onClick = {
                    currentArt =
                        if (currentArt == 0) {
                            images.size - 1
                        } else {
                            currentArt - 1
                        }
                }
            ) {
                Text("Previous")
            }

            Button(
                onClick = {
                    currentArt =
                        if (currentArt == images.size - 1) {
                            0
                        } else {
                            currentArt + 1
                        }
                }
            ) {
                Text("Next")
            }
        }
    }
}