package com.kawal.malang.officer.presentation.menus

import com.kawal.malang.citizen.model.response.pengaduan.agenda.AgendaItem
import com.kawal.malang.officer.core.util.BaseContract
import com.kawal.malang.officer.data.model.pengaduan.giat.GiatItem

interface MenusContract: BaseContract {
    fun onLoadAgenda(data:ArrayList<AgendaItem>)
    fun onLoadGiat(data:ArrayList<GiatItem>)
}