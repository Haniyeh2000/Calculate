package com.example.bookread

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {
    private const val SUPABASE_URL="https://bzmofvpquzwipfeyougx.supabase.co"
    private const val SUPABASE_KEY="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImJ6bW9mdnBxdXp3aXBmZXlvdWd4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzE3NjkwODQsImV4cCI6MjA0NzM0NTA4NH0.yWkpDFOqXGI2Z8kJfUFgVKGROCOCQX2m5a1Swso6jm8"
    val client= createSupabaseClient(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_KEY
    ){
        install(Postgrest)
    }
}