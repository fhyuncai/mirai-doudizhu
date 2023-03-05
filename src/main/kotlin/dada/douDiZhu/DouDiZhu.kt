package dada.douDiZhu

import dada.douDiZhu.command.Command
import dada.douDiZhu.command.DouDiZhuConsoleCommand
import kotlinx.coroutines.launch
import net.mamoe.mirai.console.command.CommandManager.INSTANCE.register
import net.mamoe.mirai.console.permission.AbstractPermitteeId
import net.mamoe.mirai.console.permission.PermissionService.Companion.permit
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.globalEventChannel
import net.mamoe.mirai.event.subscribeGroupMessages
import net.mamoe.mirai.utils.info

object DouDiZhu : KotlinPlugin(
    JvmPluginDescription(
        id = "dada.douDiZhu",
        version = "1.0.1",
    )
) {
    override fun onEnable() {
        logger.info { "Plugin loaded" }

        PlayerData.reload()
        Config.reload()

        Command.register()
        DouDiZhuConsoleCommand.register()

        Config.groups.forEach {
            AbstractPermitteeId.AnyMember(it).permit(Command.permission)
        }

        globalEventChannel().subscribeGroupMessages {
            case("斗地主"){
                if (group.id in Config.groups) {
                    subject.sendMessage("斗地主游戏说明\n" +
                            "发送“创建斗地主”以创建游戏\n" +
                            "创建游戏后，发送“上桌”参与游戏\n" +
                            "当上桌人数达3人后，任意玩家发送“开始游戏”即可开始斗地主\n" +
                            "开始游戏后，发送“/<你要出的牌>”在与 Bot 的私聊或者群聊中即可出牌（如“/56789”）\n" +
                            "其他指令：\n" +
                            "输入“/d beg”领取免费 Point\n" +
                            "输入“/d me”查询 Point 数量与胜率")
                }
            }
            case("创建斗地主"){
                if (group.id in Config.groups) {
                    launch { Game(group).gameStart() }
                    subject.sendMessage("创建成功（底分：200）！发送“上桌”即可参与游戏")
                }
            }
        }
    }
}