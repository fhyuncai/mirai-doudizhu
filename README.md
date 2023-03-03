# mirai-doudizhu

一个能在QQ上斗地主的mirai插件 [Download (GitHub Action)](https://github.com/fhyuncai/mirai-doudizhu/actions)

### 原项目

[https://github.com/kono-dada/doudizhu](https://github.com/kono-dada/doudizhu)
[https://github.com/CauchyDOOM/doudizhu](https://github.com/CauchyDOOM/doudizhu)

### 使用方法

* 首先你要熟知 [mirai console](https://github.com/mamoe/mirai-console/tree/03ebfd2278e9e8f051ce7f2786fb9a33efd2dbeb) 的使用方法，成功在console上运行一个bot。
* 将本插件添加至plugins文件夹。
* 在**游戏群**内发送“创建游戏”，即可创建一个游戏。
* 创建游戏后，发送“上桌”即可加入游戏
* 当上桌人数达3人后，任意玩家发送“开始游戏”即斗地主，一个能在QQ上斗地主的mirai插件。适用于mirai-console 2.6.7+

### 使用方法

将本插件添加至 `plugins` 文件夹。

在游戏群内发送“创建游戏”，即可创建一个游戏。

创建游戏后，发送“上桌”即可加入游戏

当上桌人数达3人后，任意玩家发送“开始游戏”即可开始斗
地主。出牌阶段，发送“/<你要出的牌>”在与bot的私聊或者群聊中即可出牌。如“/10jqka”就表示出了一个顺子。

当管理员发送“结束游戏”时，游戏会被强制结束。

注意，游玩斗地主的群内不要开启发言频率限制，否则会导致bot发不出消息而报错，产生收走了你的牌但没有跳出回合的bug。

### 插件的特性

覆盖全部的斗地主规则。
能够自动识别玩家出的牌是否合法。
在私聊中告知玩家所剩的牌。

v1.1新特性：

加入货币系统，斗地主能赢钱了
支持胜率的统计与查询
未来可能会有的特性：

还没想到，欢迎大家留言
游戏指令：

破产时申请补助：在群内输入“/d beg”
查询自己的point数量与胜率：在群内输入“/d me”
console指令：

添加群为游戏群：在console输入指令"/dc addgroup <群号>"即可。如"/dc addgroup 123456789"。
添加管理员：在console输入指令"/dc addadmin <QQ号>"即可。如"/dc addadmin 123456789"
