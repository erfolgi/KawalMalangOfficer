package com.kawal.malang.officer.presentation.giat.detail.komentar

import com.kawal.malang.officer.core.util.BaseContract
import com.kawal.malang.officer.data.model.PostResponse
import com.kawal.malang.officer.data.model.pengaduan.giat.KomentarItem

interface KomentarContract: BaseContract {
    fun onSubmit(data: KomentarItem)

    fun onDelete(deleted: PostResponse<KomentarItem>)
}