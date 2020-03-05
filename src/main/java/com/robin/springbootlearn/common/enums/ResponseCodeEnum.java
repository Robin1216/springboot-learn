package com.robin.springbootlearn.common.enums;

/**
 * @author silkNets
 * @description 响应码枚举，参考HTTP状态码的语义
 * @createDate 2020-03-03 08:14
 */
public enum ResponseCodeEnum {
    // === 通用 http 返回码 ===
    // 2xx （成功）表示成功处理了请求的状态代码
    code_200(200, "OK", "请求成功"),
    code_201(201, "Created", "已创建, 请求成功且服务器创建了新的资源"),
    code_202(202, "Accepted", "已接受, 服务器已接受请求，但尚未处理"),
    code_203(203, "Non-Authoritative Information", "非授权信息, 服务器已成功处理了请求，但返回的信息可能来自另一来源"),
    code_204(204, "No Content", "无内容, 服务器成功处理了请求，但不需要返回任何实体内容"),
    code_205(205, "Reset Content", "重置内容, 服务器成功处理了请求，但没有返回任何内容"),
    code_206(206, "Partial Content", "部分内容, 服务器成功处理了部分 GET 请求"),

    // 3xx （重定向）表示要完成请求，需要进一步操作。 通常，这些状态代码用来重定向
    code_300(300, "Multiple Choices", "多种选择, 针对请求，服务器可执行多种操作"),
    code_301(301, "Moved Permanently", "永久移动, 请求的网页已永久移动到新位置"),
    code_302(302, "Move Temporarily", "临时移动, 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求"),
    code_303(303, "See Other", "查看其他位置, 请求者应当对不同的位置使用单独的 GET 请求来检索响应时，服务器返回此代码"),
    code_304(304, "Not Modified", "未修改, 自从上次请求后，请求的网页未修改过。 服务器返回此响应时，不会返回网页内容"),
    code_305(305, "Use Proxy", "使用代理, 请求者只能使用代理访问请求的网页。 如果服务器返回此响应，还表示请求者应使用代理"),
    code_307(307, "Temporary Redirect", "临时重定向, 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求"),

    // 4xx（请求错误）表示请求可能出错，妨碍了服务器的处理
    code_400(400, "Bad Request", "错误请求, 服务器不理解请求的语法"),
    code_401(401, "Unauthorized", "未授权, 请求要求身份验证"),
    code_403(403, "Forbidden", "禁止, 服务器拒绝请求"),
    code_404(404, "Not Found", "未找到, 服务器找不到请求的网页"),
    code_405(405, "Method Not Allowed", "方法禁用, 禁用请求中指定的方法"),
    code_406(406, "Not Acceptable", "不接受, 无法使用请求的内容特性响应请求的网页"),
    code_407(407, "Proxy Authentication Required", "需要代理授权, 指定请求者应当授权使用代理"),
    code_408(408, "Request Timeout", "请求超时, 服务器等候请求时发生超时"),
    code_409(409, "Conflict", "冲突, 服务器在完成请求时发生冲突。 服务器必须在响应中包含有关冲突的信息"),
    code_410(410, "Gone", "已删除, 如果请求的资源已永久删除，服务器就会返回此响应"),
    code_411(411, "Length Required", "需要有效长度, 服务器不接受不含有效内容长度标头字段的请求"),
    code_412(412, "Precondition Failed", "未满足前提条件, 服务器未满足请求者在请求中设置的其中一个前提条件"),
    code_413(413, "Request Entity Too Large", "请求实体过大, 服务器无法处理请求，因为请求实体过大，超出服务器的处理能力"),
    code_414(414, "Request-URI Too Long", "请求的 URI 过长, 请求的 URI（通常为网址）过长，服务器无法处理"),
    code_415(415, "Unsupported Media Type", "不支持的媒体类型, 请求的格式不受请求页面的支持"),
    code_416(416, "Requested Range Not Satisfiable", "请求范围不符合要求, 如果页面无法提供请求的范围，则服务器会返回此状态代码"),
    code_417(417, "Expectation Failed", "未满足期望值, 服务器未满足“期望”请求标头字段的要求"),
    code_421(421, "Too Many Connections", "连接数过多, 从当前客户端所在的IP地址到服务器的连接数超过了服务器许可的最大范围"),
    code_422(422, "Unprocessable Entity", "错误请求实体, 请求格式正确，但是由于含有语义错误，无法响应"),
    code_423(423, "Locked", "锁定, 当前资源被锁定"),
    code_424(424, "Failed Dependency", "依赖错误, 由于之前的某个请求发生的错误，导致当前请求失败"),
    code_425(425, "Too Early", "超前的请求, 处理该请求可能会被“重放”，从而造成潜在的重放攻击"),
    code_426(426, "Upgrade Required", "需要更新, 客户端应当切换到TLS/1.0"),
    code_449(449, "Retry With", "重试, 由微软扩展代表请求应当在执行完适当的操作后进行重试"),
    code_451(451, "Unavailable For Legal Reasons", "法律不可用, 该请求因法律原因不可用"),

    // 5xx（服务器错误）表示服务器在尝试处理请求时发生内部错误。 这些错误可能是服务器本身的错误，而不是请求出错
    code_500(500, "Internal Server Error", "服务器内部错误, 服务器遇到错误，无法完成请求"),
    code_501(501, "Not Implemented", "尚未实施, 服务器不具备完成请求的功能"),
    code_502(502, "Bad Gateway", "错误网关, 服务器作为网关或代理，从上游服务器收到无效响应"),
    code_503(503, "Service Unavailable", "服务不可用, 服务器目前无法使用（由于超载或停机维护）"),
    code_504(504, "Gateway Timeout", "网关超时, 服务器作为网关或代理，但是没有及时从上游服务器收到请求"),
    code_505(505, "HTTP Version Not Supported", "HTTP 版本不受支持, 服务器不支持请求中所用的 HTTP 协议版本"),
    code_506(506, "Variant Also Negotiates", "内部配置错误, 被请求的协商变元资源被配置为在透明内容协商中使用自己"),
    code_507(507, "Insufficient Storage", "存储不足, 服务器无法存储完成请求所必须的内容"),
    code_509(509, "Bandwidth Limit Exceeded", "宽带超限, 服务器达到带宽限制"),
    code_510(510, "Not Extended", "不可扩展, 获取资源所需要的策略并没有被满足"),
    code_600(600, "Unparseable Response Headers", "响应头无法解析, 源站没有返回响应头部，只返回实体内容"),


    // === 业务自定义 http 返回码 ===
    code_402(402, "Token Expired", "token 已过期, token 存在但已过期"),

    // 10xx（业务校验）业务中需要校验的地方，如请求参数
    code_1001(1001, "Param Error", "参数错误"),
    code_1002(1002, "Phone Number Error", "手机号错误"),

    // 11xx（活动校验）活动相关的校验失败，如活动下线、关闭等
    code_1101(1101, "Activity Offline", "活动已下线"),
    code_1102(1102, "Activity Online", "活动已在线"),
    code_1103(1103, "Activity Not Found", "活动不存在"),
    code_1104(1104, "Activity Existed", "活动已存在"),
    code_1105(1105, "Activity Closed", "活动已结束"),
    code_1106(1106, "Activity Suspended", "活动已暂停"),
    code_1107(1107, "Activity Violated", "活动已违规"),
    code_1108(1108, "Activity Forbidden", "拒绝创建活动"),
    code_1109(1109, "Activity Under Review", "拒绝创建活动"),
    code_1110(1110, "Activity Not Self", "活动不是自己发起的"),
    code_1111(1111, "Activity Had Joined", "活动已经发起过参与过"),
    code_1112(1112, "Activity Times Upper Limit", "活动创建的上限"),

    code_1121(1121, "Vote Existed", "已帮TA助力过"),
    code_1122(1122, "Vote Not Self", "自己不能给自己投票"),
    code_1123(1123, "Vote Times Upper Limit", "砍价次数限制"),

    code_1131(1131, "Source Not Enough", "资源不足");


    // 20xx（业务风控）如黑名单，活动被限制参与、现金券限制使用等

    // 30xx（对外交互场景）如 api 请求频次限制等


    public int code;
    public String enCode;
    public String remark;

    ResponseCodeEnum(int code, String enCode, String remark) {
        this.code = code;
        this.enCode = enCode;
        this.remark = remark;
    }

    public static ResponseCodeEnum getByCode(int code) {
        ResponseCodeEnum[] enumTypes = values();
        for (ResponseCodeEnum enumType : enumTypes) {
            if (enumType.getCode() == code) {
                return enumType;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getRemark() {
        return remark;
    }

    public String getEnCode() {
        return enCode;
    }
}
