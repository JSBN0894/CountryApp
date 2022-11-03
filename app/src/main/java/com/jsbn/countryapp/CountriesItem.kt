package com.jsbn.countryapp

import Flags
import Languages
import Maps

data class CountriesItem(
    val name:Nameclass?,
    val capital: List<String>?,
    val flag: String?,
    val latlng: List<Double>,
    //val languages: Languages,
    val flags: Flags,
    val maps: Maps,


)