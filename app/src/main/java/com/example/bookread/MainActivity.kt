package com.example.bookread

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookread.ui.theme.BookReadTheme
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

val supabase = createSupabaseClient(
    supabaseUrl = "https://xyzcompany.supabase.co",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImJ6bW9mdnBxdXp3aXBmZXlvdWd4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzE3NjkwODQsImV4cCI6MjA0NzM0NTA4NH0.yWkpDFOqXGI2Z8kJfUFgVKGROCOCQX2m5a1Swso6jm8"
) {
    install(Postgrest)
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookReadTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    userlist()
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
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookReadTheme {
        Greeting("Android")
    }
}

@Composable
fun userlist(){

    var userList by remember {
        mutableStateOf<List<notes>>(listOf())
    }

    LaunchedEffect(key1 = Unit) {
        val repostory=note_Repository()
        repostory.getNotes()
            .onSuccess { userList=it }
            .onFailure { Log.d("TAGErorrrrrr$", "userlist: ") }
    }

    LazyColumn {
        items(userList)
        { note ->
            Text(text = "$note.id")
            Text(text = note.body)

        }

    }

}

@Composable
fun Item()
{

}
