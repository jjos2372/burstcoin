package brs.services

import brs.entity.FeeSuggestion
import java.awt.image.BufferedImage

@Deprecated("Replace with DeeplinkGenerator")
interface DeeplinkQRCodeGeneratorService {
    /**
     * TODO
     */
    fun generateRequestBurstDeepLinkQRCode(
        receiverId: String,
        amountPlanck: Long,
        feeSuggestionType: FeeSuggestion.Type?,
        feePlanck: Long?,
        message: String?,
        immutable: Boolean
    ): BufferedImage
}