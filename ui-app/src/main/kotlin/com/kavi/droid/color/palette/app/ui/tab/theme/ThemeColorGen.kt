package com.kavi.droid.color.palette.app.ui.tab.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.palette.app.ui.common.ThemeColorRow
import com.kavi.droid.color.palette.color.MatPackage

@Composable
fun ThemeColorGen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 24.dp, bottom = 8.dp),
                text = "Theme Color Palettes",
                style = MaterialTheme.typography.titleLarge
            )
        }

        Column(
            modifier = Modifier
                .size(720.dp)
                .verticalScroll(rememberScrollState())
        ) {
            ThemeColorRow(MatPackage.MatRed)
            ThemeColorRow(MatPackage.MatOrange)
            ThemeColorRow(MatPackage.MatDGreen)

            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = {
                }
            ) {
                Text("Try it out!")
            }
        }
    }
}

@Preview
@Composable
fun ThemeColorGenPreview() {
    ThemeColorGen(Modifier)
}