package dada.douDiZhu

import kotlinx.serialization.Serializable
import net.mamoe.mirai.console.data.AutoSavePluginData
import net.mamoe.mirai.console.data.value
import java.util.*

object PlayerData : AutoSavePluginData("playerData") {
    var data: MutableMap<Long, CustomData> by value()
}

@Serializable
data class CustomData(
    var coins: Int = 0,
    var winTimes: Int = 0,
    var gameTimes: Int = 0,
    var lastApplyTime: Long = 0L
){
    fun addPoints(number: Int) {
        if (number <= 0) throw Exception("AddMinusPoints")
        coins += number
    }

    fun pay(number: Int) {
        if (number <= 0) throw Exception("PayMinusPoints")
        coins -= number
    }

    fun dailyApply(): String {
        val lastTieDay = lastApplyTime / 1000 / 60 / 60 / 24
        val today = Date().time / 1000 / 60 / 60 / 24
        return if (today - lastTieDay >= 1) {
            coins += Config.dailyPoint//1000
            lastApplyTime = Date().time
            "又输光了吗……喏，这是${Config.dailyPoint}个 Point，别再输了哦"
        } else
            "你今天已经领取过${Config.dailyPoint}个 Point 了，别得寸进尺了哦！"
    }
}
