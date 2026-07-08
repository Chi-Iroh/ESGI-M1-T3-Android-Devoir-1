package com.example.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardDoubleArrowRight
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
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
                        description = "Android",
                        phoneNumber = "Android",
                        skills = listOf(),
                        projects = listOf(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Header(name: String, occupation: String, description: String, modifier: Modifier = Modifier) {
    Row() {
        Column {
            Text(
                text = name,
                fontSize = 24.sp
            )
            Text(
                text = occupation,
                fontSize = 16.sp
            )
            Text(
                text = description,
                fontSize = 12.sp
            )
        }
        Image(
            imageVector = Icons.Default.AcUnit,
            contentDescription = "Il fait chaud",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun SkillItem(skill: String, modifier: Modifier = Modifier) {
    Row() {
        Icon(
            imageVector = Icons.Default.KeyboardDoubleArrowRight,
            contentDescription = "Petite flèche >>"
        )
        Text(
            text = skill,
            fontSize = 12.sp
        )
    }
}

@Composable
fun Skills(skills: List<String>, modifier: Modifier = Modifier) {
    LazyColumn (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
            item {
                Text(
                    text = "Compétences :"
                )
            }

            items(items = skills) {
                item -> SkillItem(item, modifier)
            }
    }
}

@Composable
fun ProjectItem(project: String) {
    Row() {
        Icon(
            imageVector = Icons.Default.Lightbulb,
            contentDescription = "Une petite ampoule ^^"
        )
        Text(text = project)
    }
}

@Composable
fun Projects(projects: List<String>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text("Projets :")
        }
        items(items = projects) {
            project -> ProjectItem(project)
        }
    }
}

@Composable
fun GitHubButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = Modifier.fillMaxWidth().clickable(role = Role.Button, onClick = onClick).semantics {
        contentDescription = text
    }) {
        Text(text = text)
    }
}

@Composable
fun PhoneNumber(number: String, modifier: Modifier) {
    Text(
        text = "Appelez-moi au $number",
        modifier = modifier.padding(30.dp) // padding interne
    )
}

@Composable
fun Profile(name: String, occupation: String, description: String, phoneNumber: String, skills: List<String>, projects: List<String>, modifier: Modifier = Modifier) {
    Surface(modifier = modifier) {
        Column {
            Header(name = name, occupation, description = description, modifier = modifier.padding(all = 16.dp))
            Skills(skills = skills, modifier = modifier)
            Projects(projects = projects)
            PhoneNumber(phoneNumber, modifier)
            GitHubButton(text = "Voir sur GitHub", onClick = {}, modifier = modifier.padding(32.dp).fillMaxWidth())
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
            description = "Étudiant, j'aime le bas niveau.",
            phoneNumber = "01.02.03.04.05",
            skills = listOf("C", "C++", "Haskell", "Python", "IBM RPG"),
            projects = listOf("Émulateur CHIP-8 (C, C++, C#, Haskell, Rust)", "Compression binaire de fichiers de parties d'échecs", "Pong sur Nintendo DS"),
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
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            phoneNumber = "06.07.08.09.00",
            skills = listOf("HTML", "CSS", "JavaScript", "PHP", "React"),
            projects = listOf("Site e-commerce")
        )
    }
}
