# mirai-doudizhu

一个能在QQ上斗地主的 mirai-console 插件

[Download Release](https://github.com/fhyuncai/mirai-doudizhu/releases)

### 原项目

[https://github.com/kono-dada/doudizhu](https://github.com/kono-dada/doudizhu)

[https://github.com/CauchyDOOM/doudizhu](https://github.com/CauchyDOOM/doudizhu)

### 使用方法

- 将本插件添加至 mirai-console 目录的 `plugins` 文件夹。
- 在**游戏群**内发送“创建斗地主”，即可创建一个游戏。
- 创建游戏后，发送“上桌”即可加入游戏。
- 当上桌人数达3人后，任意玩家发送“开始游戏”即可开始斗地主。
- 出牌阶段，发送“/<你要出的牌>”在与 Bot 的私聊或者群聊中即可出牌 (如“/56789”就表示出了一个顺子)。
- 管理员发送“结束斗地主”时，游戏会被强制结束。

### 注意

- 游玩斗地主的群内不要开启发言频率限制，否则会导致 Bot 发不出消息而报错，产生收走了你的牌但没有跳出回合的 Bug。
- 开始前需要群聊开启“发起临时会话”功能或者玩家添加 Bot 为好友，否则可能无法发牌导致报错。

### 插件特性

- 覆盖全部的斗地主规则
- 能够自动识别玩家出的牌是否合法
- 在私聊中告知玩家所剩的牌
- 货币系统
- 胜率的统计与查询

#### 游戏指令 (群聊)

- 获取帮助: `斗地主`
- 创建游戏: `创建斗地主`
- 领取 Point: `/d beg`
- 查询 Point 与胜率: `/d me`

#### Console 指令

- 添加游戏群: `/dc addgroup <群号>` (如 `/dc addgroup 123456789`)
- 添加管理员: `/dc addadmin <QQ号>` (如 `/dc addadmin 123456789`)
