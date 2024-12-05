package com.example.bookread

import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class note_Repository {
    private val supabase=SupabaseClient.client

    suspend fun getNotes():Result<List<notes>>{
        return try {
            val response=supabase
                .from("notes")
                .select(columns = Columns.list("id","body"))
                .decodeList<notes>()

            Result.success(response)
        }
        catch (e:Exception){
            Result.failure(e)
        }
    }
}