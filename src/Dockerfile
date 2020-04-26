# FROM 指令必须为Dockerfile文件开篇的第一个非注释行，用于指定构建镜像所使用的基础镜像，
# 后续的指令运行都要依靠此基础镜像所提供的的环境（简单说就是假如Dockerfile中所引用的基础镜像里面没有mkdir命令，那后续的指令是没法使用mkdir参数的。）
# 实际使用中，如果没有指定仓库，docker build会先从本机查找是否有此基础镜像，如果没有会默认去Docker Hub Registry上拉取，再找不到就会报错。
# 格式：FROM <image>[:<Tag>] 或 FROM <image>@<Digest> Digest：镜像的哈希码，防止镜像被冒名顶替。
FROM openjdk:8u252-slim

# MAINTAINER 用于让Dockerfile的作者提供个人的信息; Dockerfile 并不限制 MAINTAINER 指令的位置，但是建议放在FROM指令之后; 在较新的docker版本中，已经被LABEL替代。
# 格式：MAINTAINER <name>
MAINTAINER robin

# LABEL 同 docker run -l; 让用户为镜像指定各种元数据（键值对的格式）。
# 格式：LABEL  <key>=<value> <key>=<value>
# 示例：LABEL version="1.0.0" description="springboot learn project" by="robin"
# 注：使用LABEL指定元数据时，一条 LABEL 指定可以指定一或多条元数据，指定多条元数据时不同元数据之间通过空格分隔。推荐将所有的元数据通过一条 LABEL 指令指定，以免生成过多的中间镜像。

# WORKDIR 同docker run -w，指定工作目录，可以指多个，每个 WORKDIR 只影响他下面的指令，直到遇见下一个 WORKDIR 为止。WORKDIR 也可以调用由 ENV 指令定义的变量
# WORKDIR 相对路径或者绝对路径，相对路径是相对于上一个 WORKDIR 指令的路径，如果上面没有 WORKDIR 指令，那就是当前 Dockerfile 文件的目录。
# 格式：WORKDIR /path/to/workdir
# 示例：
# WORKDIR /a  (这时工作目录为/a)
# WORKDIR b  (这时工作目录为/a/b)
# WORKDIR c  (这时工作目录为/a/b/c)
# 注：通过WORKDIR设置工作目录后，Dockerfile中其后的命令RUN、CMD、ENTRYPOINT、ADD、COPY等命令都会在该目录下执行。在使用docker run运行容器时，可以通过-w参数覆盖构建时所设置的工作目录。

# VOLUME docker run -v简化版；用于在镜像中创建一个挂载点目录。
# Volume有两种类型：绑定挂载卷和docker管理的卷。在dockerfile中只支持docker管理的卷，也就是说只能指定容器内的路径，不能指定宿主机的路径。
# 格式：VOLUME <mountpoint> 或 VOLUME ["<mountpoint>"]
# 示例：VOLUME ["/data"] 或 VOLUME ["/var/www", "/var/log/apache2", "/etc/apache2"]

# EXPOSE 同docker run --expose；
# 指定容器中待暴露的端口。比如容器提供的是一个 https 服务且需要对外提供访问，那就需要指定待暴露 443 端口，然后在使用此镜像启动容器时搭配 -P 的参数才能将待
# 暴露的状态转换为真正暴露的状态，转换的同时443也会转换成一个随机端口，跟 -p :443一个意思。
# EXPOSE 指令可以一次指定多个端口，例如：EXPOSE 11111/udp 11112/tcp
# 格式：EXPOSE <port>[/<protocol>] [<port>[/<protocol>] ...] <protocol>用于指定协议类型，如果不指定，默认TCP协议。
# 注：EXPOSE 并不会让容器的端口访问到主机。要使其可访问，需要在docker run运行容器时通过-p来发布这些端口，或通过-P参数来发布EXPOSE导出的所有端口

# ENV 同docker run -e；为镜像定义所需的环境变量，并可被ENV指令后面的其它指令所调用。调用格式为$variable_name或者${variable_name}
# 使用docker run启动容器的时候加上 -e 的参数为variable_name赋值，可以覆盖Dockerfile中ENV指令指定的此variable_name的值。但是不会影响到dockerfile中已经引用过此变量的文件名
# 格式：ENV <key> <value> 此格式一次只能定义一个变量，<key>之后所有内容都会被视为<value>的组成部分；
# 或 ENV <key>=<value> ...此格式一次可以定义多个变量，每个变量为一个"="的键值对，如果<value>中包含空格，可以用反斜线\进行转义，也可以为<value>加引号，另外参数过长时可用反斜线做续行。
# 定义多个变量时，建议使用第二种方式，因为Dockerfile中每一行都是一个镜像层，构建起来比较吃资源。
ENV TZ=Asia/Shanghai

# RUN 用于指定 docker build 过程中运行的程序，可以是任何命令。RUN 指令后所执行的命令必须在 FROM 指令后的基础镜像中存在才行。
# 格式：RUN <command> <command>通常是一个shell命令，系统默认会把后面的命令作为shell的子进程来运行，以"/bin/sh -c"来运行它，也就意味着此进程在容器中的PID一定不为1，如果是1完事就结束了哇。
# 或 RUN ["executable", "param1", "param2"] 此格式的参数是一个JSON格式的数组，其中"executable"为要运行的命令，后面的"paramN"为传递给命令的选项或参数。
# 此格式指定的命令不会以"/bin/sh -c"来发起，也就是直接由内核创建，因此不具备shell特性，类似于RUN [ "echo", "$HOME" ]，是无法识别 $ 的；如果想要依赖shell特性，可以替换命令为这样的格式[ "/bin/sh", "-c", "echo $HOME" ]。
# 注：RUN 指令创建的中间镜像会被缓存，并会在下次构建中使用。如果不想使用这些缓存镜像，可以在构建时指定 --no-cache 参数
# RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN apk update  && apk add --no-cache && apk add curl bash tree tzdata && cp  /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo "Asia/Shanghai" > /etc/timezone

# 复制宿主机上的文件到目标镜像中
# 格式：COPY <src>... <dest> 或 COPY ["<src>",... "<dest>"]。
# <src>：要复制的源文件或者目录，支持通配符；<dest>：目标路径，即正创建的镜像的文件系统路径，建议使用绝对路径，否则，COPY指令会以WORKDIR为其起始路径。
# 如果路径中如果包含空白字符，建议使用第二种格式用引号引起来，否则会被当成两个文件。
# 注意：1、<src>必须是build上下文中的目录，不能是其父目录中的文件。2、如果<src>是目录，则其内部的文件或则子目录会被递归复制，但<src>目录本身不会被复制。
# 3、如果指定了多个<src>，或者<src>中使用通配符，则<dest>必须是一个目录，且必须以 / 结尾。 4、如果<dest>事先不存在，它将会被自动创建，包括其父目录路径。
# COPY  /etc/src /etc/dest
# COPY target/springboot-learn.jar /usr/app/springboot-learn-1.0.0-SNAPSHOT.jar

# ADD指令跟COPY类似，不过它还支持使用tar文件和URL路径。
# 当拷贝的源文件是tar文件时，会自动展开为一个目录并拷贝进新的镜像中；然而通过URL获取到的tar文件不会自动展开。
# 主机可以联网的情况下，docker build可以将网络上的某文件引用下载并打包到新的镜像中。
# 格式：ADD <src>... <dest> 或 ADD ["<src>",... "<dest>"]
# 示例：ADD /etc/src /etc/dest
ADD target/springboot-learn-1.0.0-SNAPSHOT.jar /usr/app/springboot-learn-1.0.0-SNAPSHOT.jar

# CMD 指定启动容器的默认要运行的程序，也就是PID为1的进程命令，且其运行结束后容器也会终止。如果不指定，默认是bash。
# CMD 指令指定的默认程序会被 docker run 命令行指定的参数所覆盖。Dockerfile 中可以存在多个 CMD 指令，但仅最后一个生效。因为一个docker容器只能运行一个PID为1的进程。
# 类似于RUN指令，也可以运行任意命令或程序，但是两者的运行时间点不同，RUN 指令运行在 docker build 的过程中，而 CMD 指令运行在基于新镜像启动容器（docker run）时。
# 格式：CMD command param1 param2 同 RUN 指令，执行shell内部命令，此用法对于CMD指令基本没有意义，因为它运行的程序PID不为1
# 或 CMD ["executable","param1","param2"] 同 RUN 指令
# 或 CMD ["param1","param2"] 需要结合ENTRYPOINT 指令使用，CMD 指令后面的命令作为 ENTRYPOINT 指令的默认参数。如果 docker run 命令行结尾有参数指定，那 CMD 后面的参数不生效。
# 注意：这里边包括参数的一定要用双引号，就是",不能是单引号。千万不能写成单引号。原因是参数传递后，docker 解析的是一个 JSON array
CMD ["java", "-jar", "-Dfile.encoding=UTF8", "-Duser.timezone=GMT+08", "-Dfastjson.parser.autoTypeSupport=true", "/var/app/springboot-learn-1.0.0-SNAPSHOT.jar"]

# ENTRYPOINT 类似 CMD 指令的功能，用于为容器指定默认运行程序。dockerfile 中可以存在多个 ENTRYPOINT 指令，但仅最后一个生效.
# 与 CMD 区别在于，由 ENTRYPOINT 启动的程序不会被 docker run 命令行指定的参数所覆盖，而且这些命令行参数会被当做参数传递给 ENTRYPOINT 指令指定的程序。
# Docker run 的 --entrypoint 选项的参数可覆盖 ENTRYPOINT 指定的默认程序
# 格式：ENTRYPOINT command param1 param2 或 ENTRYPOINT ["executable", "param1", "param2"]
ENTRYPOINT ["java","-jar", "-Xms128m", "-Xmx2048m", "/usr/local/springboot-learn-1.0.0-SNAPSHOT.jar"]

# USER 用于指定docker build过程中任何RUN、CMD等指令的用户名或者UID。默认情况下容器的运行用户为root。
# 格式：USER <user>[:<group>] 或 USER <UID>[:<GID>] 实践中UID需要是/etc/passwd中某用户的有效UID，否则docker run命令将运行失败。
#

# HEALTHCHECK 顾名思义，健康检查。此指令的就是告诉docker如果检查容器是否正常工作。拿nginx举例，即便进程运行，服务也不一定正常，因为万一root指错了呢？
# 格式：HEALTHCHECK [OPTIONS] CMD command  或 HEALTHCHECK NONE（不做健康检查）
# HEALTHCHECK指令让我们去定义一个CMD，在CMD后面编写一条命令去判断我们的服务运行是否正常。检查肯定不是一次性的，所以OPTIONS就是指定检查的频率等等。
# --interval=DURATION（默认值：30s）：每隔多久检查一次，默认30s
# --timeout=DURATION（默认值：30s）：超时时长，默认30s
# --start-period=DURATION（默认值：0s）：启动健康检查的等待时间。因为容器启动成功时，进程不一定立马就启动成功，那过早开始检查就会返回不健康。
# --retries=N（默认值：3）：如果检查一次失败就返回不健康未免太武断，所以默认三次机会。
# CMD健康检测命令发出时，返回值有三种情况：0：成功，1：不健康，2：保留，无实际意义。
# 如 HEALTHCHECK --interval=5m --timeout=3s CMD curl -f http://localhost/ || exit 1

# SHELL 用来指定运行程序默认要使用的shell类型，因为windows环境默认是powershell。此指令一般不会使用。
# 格式：SHELL ["executable", "parameters"]
#

# STOPSIGNAL 指定发送使容器退出的系统调用信号。docker stop之所以能停止容器，就是发送了15的信号给容器内PID为1的进程。此指令一般不会使用。
# 格式：STOPSIGNAL signal
#

# ARG ARG命令同EVN类似，也是指定一个变量，但不同的是，ENV指令配合-e参数可以在docker run过程中传参，而使用ARG指令配合--build-arg参数可以在docker build过程中传参，这方便了我们为不同场景构建不同镜像。
# 格式：ARG <name>[=<default value>]
# 示例：ARG build_user=www

# ONBUILD 用于在 Dockerfile 中定义一个触发器。
# ONBUILD 后面指定的指令在docker build时是不会执行，构建完的镜像在被另一个Dockerfile文件中FROM指令所引用的时才会触发执行。
# ONBUILD [INSTRUCTION]
# 几乎任何指令都可以成为触发器指令，但ONBUILD不能自我嵌套，且不会触发FROM和MAINTAINER指令，多数情况是使用RUN或者ADD。
# 另外在使用COPY指令时，应该注意后续引用该镜像的Dockerfile的同级目录下是否有被拷贝的文件。
# 示例：ONBUILD RUN /usr/local/bin/python-build --dir /app/src 或 ONBUILD ADD . /app/src

#
#
#
#

