package dada.douDiZhu.command

import dada.douDiZhu.*
import net.mamoe.mirai.console.command.CompositeCommand
import net.mamoe.mirai.console.command.ConsoleCommandSender
import net.mamoe.mirai.console.command.UserCommandSender
import net.mamoe.mirai.console.permission.AbstractPermitteeId
import net.mamoe.mirai.console.permission.PermissionService.Companion.permit

object Command : CompositeCommand(
    DouDiZhu,
    "d",
) {
    @SubCommand("beg")
    suspend fun UserCommandSender.beg() {
        val msg = user.data.dailyApply()
        subject.sendMessage(msg)
    }

    //查询玩家的胜率
    @SubCommand("me")
    suspend fun UserCommandSender.me() {
        var winRate = 0.0
        if (!user.winRate.isNaN()) winRate = user.winRate
        subject.sendMessage("<${user.nick}>现在有${user.data.coins}个Point，总共进行了${user.gameTimes}场游戏，" +
                "获胜${user.winTimes}场，胜率${winRate}")
    }


}

/**
 * 斗地主管理指令
 * 可以进行管理员和群聊的添加
 */
object DouDiZhuConsoleCommand : CompositeCommand(
    DouDiZhu,
    "doudizhucommand", "dc"
) {
    @SubCommand("addadmin")
    suspend fun ConsoleCommandSender.addAdmin(id: Long) {
        Config.admin.add(id)
        AbstractPermitteeId.ExactUser(id).permit(Command.permission)
        sendMessage("OK")
    }

    @SubCommand("addgroup")
    suspend fun ConsoleCommandSender.addGroup(id: Long) {
        Config.groups.add(id)
        AbstractPermitteeId.AnyMember(id).permit(Command.permission)
        sendMessage("OK")
    }
}
