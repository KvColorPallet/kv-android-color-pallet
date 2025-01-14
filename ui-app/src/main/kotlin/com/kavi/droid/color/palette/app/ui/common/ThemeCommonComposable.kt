package com.kavi.droid.color.palette.app.ui.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.palette.KvColorPalette
import com.kavi.droid.color.palette.model.KvColor

@Composable
fun ColorCircle(givenColor: Color, colorLetter: String = "", letterColor: Color = MaterialTheme.colorScheme.onPrimary) {

    val circleSize = 48.dp

    Box(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Canvas(
            modifier = Modifier.size(circleSize)
        ) {
            drawCircle(color = givenColor, radius = circleSize.toPx() / 2)
        }

        Text(colorLetter, modifier = Modifier
            .padding(8.dp)
            .align(Alignment.Center),
            style = MaterialTheme.typography.bodyLarge,
            color = letterColor
        )
    }
}

@Composable
fun ThemeColorRow(givenColor: KvColor) {
    Box(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Row(modifier = Modifier
            .border(1.dp, Color.White, shape = RoundedCornerShape(8.dp))
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box (modifier = Modifier
                .width(60.dp)
                .height(220.dp)
                .padding(top = 16.dp, start = 16.dp, end = 4.dp, bottom = 16.dp)
                .background(givenColor.color)
            ) {
                Text("BASE",
                    modifier = Modifier
                        .padding(8.dp)
                        .width(2.dp),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            Column(modifier = Modifier
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
            ) {
                val appThemeColorSet = KvColorPalette.instance.generateThemeColorPalette(
                    givenColor = givenColor.color,
                )

                Text("Light Theme", Modifier.padding(top = 8.dp, start = 8.dp), style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.ExtraBold,)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp),
                    //horizontalArrangement = Arrangement.Center
                ) {
                    ColorCircle(appThemeColorSet.light.primary, colorLetter = "P")
                    ColorCircle(appThemeColorSet.light.secondary, colorLetter = "S")
                    ColorCircle(appThemeColorSet.light.tertiary, colorLetter = "T")
                    ColorCircle(appThemeColorSet.light.background, colorLetter = "B", letterColor = Color.Black)
                }

                Text("Dark Theme", Modifier.padding(top = 8.dp, start = 8.dp), style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.ExtraBold,)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp),
                    //horizontalArrangement = Arrangement.Center
                ) {
                    ColorCircle(appThemeColorSet.dark.primary, colorLetter = "P")
                    ColorCircle(appThemeColorSet.dark.secondary, colorLetter = "S", letterColor = Color.Black)
                    ColorCircle(appThemeColorSet.dark.tertiary, colorLetter = "T")
                    ColorCircle(appThemeColorSet.dark.background, colorLetter = "B")
                }
            }
        }
    }
}