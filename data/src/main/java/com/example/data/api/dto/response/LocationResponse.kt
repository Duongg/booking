package com.example.data.api.dto.response

import com.google.gson.annotations.SerializedName


data class LocationResponse(
    @SerializedName("roundtrip"      ) var roundtrip   : String?      = null,
    @SerializedName("city_name"      ) var cityName    : String?      = null,
    @SerializedName("label"          ) var label       : String?      = null,
    @SerializedName("cc1"            ) var cc1         : String?      = null,
    @SerializedName("type"           ) var type        : String?      = null,
    @SerializedName("dest_id"        ) var destId      : String?      = null,
    @SerializedName("rtl"            ) var rtl         : Int?         = null,
    @SerializedName("region"         ) var region      : String?      = null,
    @SerializedName("timezone"       ) var timezone    : String?      = null,
    @SerializedName("image_url"      ) var imageUrl    : String?      = null,
    @SerializedName("hotels"         ) var hotels      : Int?         = null,
    @SerializedName("city_ufi"       ) var cityUfi     : String?      = null,
    @SerializedName("b_max_los_data" ) var bMaxLosData : BMaxLosData? = null,
    @SerializedName("dest_type"      ) var destType    : String?      = null,
    @SerializedName("lc"             ) var lc          : String?      = null,
    @SerializedName("longitude"      ) var longitude   : Double?      = null,
    @SerializedName("latitude"       ) var latitude    : Double?      = null,
    @SerializedName("name"           ) var name        : String?      = null,
    @SerializedName("nr_hotels"      ) var nrHotels    : Int?         = null,
    @SerializedName("country"        ) var country     : String?      = null

)

data class BMaxLosData (

    @SerializedName("experiment"       ) var experiment     : String? = null,
    @SerializedName("extended_los"     ) var extendedLos    : Int?    = null,
    @SerializedName("has_extended_los" ) var hasExtendedLos : Int?    = null,
    @SerializedName("default_los"      ) var defaultLos     : Int?    = null,
    @SerializedName("is_fullon"        ) var isFullon       : Int?    = null,
    @SerializedName("max_allowed_los"  ) var maxAllowedLos  : Int?    = null

)