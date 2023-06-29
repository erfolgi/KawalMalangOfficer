package com.kawal.malang.officer.presentation.agenda

import com.kawal.malang.citizen.model.response.pengaduan.agenda.AgendaItem
import com.kawal.malang.officer.core.util.BaseContract

interface AgendaContract : BaseContract {
    fun onLoad(data:ArrayList<AgendaItem>)
}