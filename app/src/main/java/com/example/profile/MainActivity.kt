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
import androidx.compose.material3.Button
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
                        occupation = "Android",
                        phoneNumber = "Android",
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
        fontSize = 24.sp
    )
    Text(
        text = occupation,
        fontSize = 16.sp
    )
}

@Composable
fun SkillItem(skill: String, modifier: Modifier = Modifier) {
    Text(
        text = "- $skill",
        fontSize = 12.sp
    )
}

@Composable
fun Skills(skills: List<String>, modifier: Modifier = Modifier) {
    Text(
        text = "Compétences :"
    )
    skills.forEach { skill -> SkillItem(skill, modifier) }
}

@Composable
fun GitHubButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier.fillMaxWidth()) {
        Text(text = text)
    }
}

@Composable
fun PhoneNumber(number: String, modifier: Modifier) {
    Text(
        text = "Appelez-moi au $number"
    )
}

@Composable
fun Profile(name: String, occupation: String, phoneNumber: String, skills: List<String>, modifier: Modifier = Modifier) {
    Surface(modifier = modifier) {
        Column {
            Header(name = name, occupation, modifier = modifier.padding(all = 16.dp))
            Skills(skills = skills, modifier = modifier)
            PhoneNumber(phoneNumber, modifier)
            GitHubButton(text = "Voir sur GitHub", onClick = {}, modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MePreview() {
    ProfileTheme {
        Profile(
            name = "Thomas Sayen",
            occupation = "Développeur C & C++",
            phoneNumber = "01.02.03.04.05",
            skills = listOf("C", "C++", "Haskell", "Python", "IBM RPG"),
            modifier = Modifier.padding(24.dp) // padding externe
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JohnDoePreview() {
    ProfileTheme {
        Profile(
            name = "John Doe",
            occupation = "Développeur web",
            phoneNumber = "06.07.08.09.00",
            skills = listOf("HTML", "CSS", "JavaScript", "PHP", "React"),
            modifier = Modifier.padding(24.dp) // padding externe
        )
    }
}
