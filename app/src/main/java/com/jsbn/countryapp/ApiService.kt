package com.jsbn.countryapp
//import com.squareup.moshi.Moshi
//import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://restcountries.com/v3.1/"

/*
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

 */

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface ApiService{
    @GET("all")
    suspend fun getCountry() : Response<List<CountriesItem>>
}

object CountryApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}