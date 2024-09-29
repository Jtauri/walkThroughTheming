package com.example.walkthroughtheming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
//MyThemen sijasta tuossa on tuo WalkThroughThemingTheme
import com.example.walkthroughtheming.ui.theme.WalkThroughThemingTheme
import androidx.compose.material3.ButtonDefaults

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.OutlinedTextField


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalkThroughThemingTheme {
                //My Title oli tilapalkin päällä niin innerPaddingillä sen sen sai sit alemmas
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Text("Button Text")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WalkThroughThemingTheme {
        Greeting("Android")
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    // Define a Modifier to be reused across multiple components
    val appModifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)

    // The Column holds the composables vertically
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Text composable, styled with MaterialTheme's typography
        Text(
            text = "My Title",
            style = MaterialTheme.typography.headlineSmall, // Material 3 equivalent to h5
            modifier = appModifier
        )

        // OutlinedTextField for input, with basic functionality
        OutlinedTextField(
            value = "", // Bind this with a state
            onValueChange = { /* Handle input */ },
            modifier = appModifier
        )

        // Button with an action
        Button(
            onClick = { /* Handle click */ },
            modifier = appModifier
        ) {
            Text(text = "Submit")
        }
    }
}
