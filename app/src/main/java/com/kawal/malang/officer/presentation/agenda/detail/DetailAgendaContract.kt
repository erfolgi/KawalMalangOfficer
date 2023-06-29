package com.kawal.malang.officer.presentation.agenda.detail

import com.kawal.malang.citizen.model.response.pengaduan.agenda.AgendaItem
import com.kawal.malang.officer.core.util.BaseContract

interface DetailAgendaContract: BaseContract {
    fun onLoad(data: AgendaItem)
}