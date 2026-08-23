package com.shash.myapplication.clean_architecture_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.shash.myapplication.normal_calculator.CalculatorButton
import com.shash.myapplication.MyApplication
import com.shash.myapplication.clean_architecture_calculator.presentation.ui.calculator.CalculatorViewModel
import com.shash.myapplication.clean_architecture_calculator.ui.theme.MyApplicationTheme
import javax.inject.Inject

class MainActivityCalculator : ComponentActivity() {

    @Inject
    lateinit var viewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                // Observe flow state reactively in Compose
                val currentInput by viewModel.inputState.collectAsStateWithLifecycle()

                CalculatorScreen(
                    input = currentInput,
                    onActionClick = { action -> viewModel.onAction(action) }
                )
            }
        }
    }
}

@Composable
fun CalculatorScreen(
    input: String,
    onActionClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding() // Ensures safe drawing over status and nav bars
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = input.ifEmpty { "0" },
            fontSize = 48.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End
        )

        val buttons = listOf(
            listOf("7", "8", "9", "/"),
            listOf("4", "5", "6", "*"),
            listOf("1", "2", "3", "-"),
            listOf("C", "0", "=", "+"),
        )

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            buttons.forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    row.forEach { label ->
                        CalculatorButton(
                            label = label,
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f),
                            onClick = { onActionClick(label) }
                        )
                    }
                }
            }
        }
    }
}