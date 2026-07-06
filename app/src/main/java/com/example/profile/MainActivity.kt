package com.example.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.ui.theme.ProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Profile(
                        name = "Android",
                        skills = listOf(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Header(name: String, occupation: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier,
        fontSize = 24.sp
    )
    Text(
        text = occupation,
        modifier = modifier,
        fontSize = 16.sp
    )
}

@Composable
fun SkillItem(skill: String, modifier: Modifier = Modifier) {
    Text(
        text = "- $skill",
        modifier = modifier,
        fontSize = 12.sp
    )
}

@Composable
fun Skills(skills: List<String>, modifier: Modifier = Modifier) {
    Text(
        text = "Compétences :",
        modifier = modifier
    )
    skills.forEach { skill -> SkillItem(skill, modifier) }
}

@Composable
fun Profile(name: String, skills: List<String>, modifier: Modifier = Modifier) {
    Surface(modifier = modifier) {
        Column {
            Header(name = name, "Développeur C & C++", modifier = modifier)
            Skills(skills = skills, modifier = modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProfileTheme {
        Profile("Thomas Sayen", listOf("C", "C++", "Haskell", "Python", "IBM RPG"))
    }
}