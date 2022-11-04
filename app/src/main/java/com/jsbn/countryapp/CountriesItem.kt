package com.jsbn.countryapp

import Flags
import Languages
import Maps

data class CountriesItem(
    val name:Nameclass,
    val capital: List<String>?,
    val latlng: List<Double>,
    val region: String,
    val subregion: String,
    val population: Int,
    val continents: List<String>,
    val flags: Flags
)