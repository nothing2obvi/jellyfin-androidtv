package org.jellyfin.androidtv.util.sdk

import org.jellyfin.sdk.model.api.CollectionType

fun CollectionType?.isMusicVideo() = this?.name == "MUSICVIDEOS"
