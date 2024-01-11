package com.prvt.microtecact.data.models

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)