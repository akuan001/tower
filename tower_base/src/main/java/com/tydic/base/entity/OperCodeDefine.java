package com.tydic.base.entity;

/**
 * 异常定义码
 */
public class OperCodeDefine {

    public static final String OPER_SUCCESS = "0000"; // 操作成功返回码
    public static final String OPER_DB_FAILED = "0001"; // 操作DB失败
    public static final String QUERY_DB_FAILED = "0002"; // 查询DB失败
    public static final String OPER_PARAMTER_ERROR = "0003"; // 传入参数错误
    public static final String UPDATE_STATUS_FAILED = "0004"; // 更新状态失败
    public static final String OPER_DATE_ISNULL = "0005"; // 更新值为空
    public static final String USER_PRIMARYKEY_EXIST = "0006"; // 主表主键冲突
    public static final String LOG_PRIMARYKEY_EXIST = "0007"; // 日志主键冲突
    public static final String PARAMTER_CON_ERROR = "0008"; // 参数转移异常
    public static final String ACCESS_RIGHTS_ERROR = "0009"; // 访问权限异常
    public static final String CONN_DB_TYPE_ERROR = "0010"; // 连接类型错误
    public static final String UNKNOW_ERROR = "9999"; // 未知异常
    public static final String PARSE_TEXT_ERROR = "0011"; // 解析参数错误
    public static final String DATA_CONF_ERROR = "0012"; // 数据库配置错误
    public static final String GET_XML_ERROR = "0013"; // 返回报文错误
    public static final String GET_REDIS_ERROR = "0014"; // 获取redis异常
    public static final String OPER_REDIS_ERROR = "0015"; // set redis异常
    public static final String STAFF_STATUS_ERROR = "0016"; // 用户状态为异常
    public static final String PRIMARYKEY_EXCEPTION = "0017"; // 获取主键异常
    public static final String USER_PASSWORD_ERROR = "0018"; // 用户名密码错误
    public static final String USER_AGAINPASSWORD_ERROR = "0019"; //两次密码不一致
    public static final String OPER_DELETE_FAILED= "0020"; // 删除失败编码
    public static final String IS_TRUE_FLAG= "0021"; // 创建信息可用编码
    public static final String IS_FLASE_FLAG= "0022"; // 创建信息不可用编码
    public static final String STAFF_STATUS_UNEXIST = "0023"; // 用户不存在
    public static final String STAFF_STATUS_LOCK = "0024"; // 用户被锁定
    public static final String OPEN_SEARCH_CLIENT_PROTOCOL_EXCEPTION = "0025"; // OpenSearch客户端协议异常
    public static final String OPEN_SEARCH_IO_ERROR = "0026"; // OpenSearch上传文档IO操作异常
    public static final String FILE_NOT_FOUND = "0027";//文件不存在
    public static final String FILE_UPLOAD_ERROR ="0028";//文件上传失败
    public static final String FILE_DOWNLOAD_ERROR ="0029";//文件下载失败
    public static final String EXISTED_ANSWER_SHEET_ERROR ="0030";//已存在报价清单，不能重复报价
    public static final String EXPORT_EXCEL_ERROR ="0031";//导出内容到Excel时报错
    public static final String SEQUENCE_GENERATE_ERROR ="0032";//Sequence生成主键Id时发生异常
    public static final String DATE_FORMAT_ERROR ="0033";//日期转换异常
    public static final String CODE_EXIST_ERROR ="0034";//编号已经存在
    public static final String OPEN_SEARCH_UNKNOWN_HOST_EXCEPTION ="0035";//OpenSearch创建客户端时，未知主机异常
    public static final String COMMODITY_NOT_EXIST ="0036";//OpenSearch创建客户端时，未知主机异常
    public static final String SIGINST_IS_NULL ="0037";//OpenSearch创建客户端时，未知主机异常
    public static final String COMMODITY_DELETED ="0038";//OpenSearch创建客户端时，未知主机异常
    public static final String COMMODITY_UNSHELVED ="0039";//OpenSearch创建客户端时，未知主机异常
    public static final String COMMODITY_SHELVED ="0040";//OpenSearch创建客户端时，未知主机异常
    public static final String COMMODITY_DRAFT ="0041";//OpenSearch创建客户端时，未知主机异常
    public static final String ENCRYPT_TEXT_ERROR = "0042"; // 加密参数错误



    public static final String OPER_SUCCESS_NAME = "操作成功"; // 操作成功返回码
    public static final String OPER_DB_FAILED_NAME = "操作DB失败"; // 操作DB失败
    public static final String QUERY_DB_FAILED_NAME = "查询DB失败"; // 查询DB失败
    public static final String OPER_PARAMTER_ERROR_NAME = "传入参数错误"; // 传入参数错误
    public static final String UPDATE_STATUS_FAILED_NAME = "更新状态失败"; // 更新状态失败
    public static final String OPER_DATE_ISNULL_NAME = "更新值为空"; // 更新值为空
    public static final String USER_PRIMARYKEY_EXIST_NAME = "主表主键冲突"; // 主表主键冲突
    public static final String LOG_PRIMARYKEY_EXIST_NAME = "日志主键冲突"; // 日志主键冲突
    public static final String PARAMTER_CON_ERROR_NAME = "参数转移异常"; // 参数转移异常
    public static final String ACCESS_RIGHTS_ERROR_NAME = "访问权限异常"; // 访问权限异常
    public static final String CONN_DB_TYPE_ERROR_NAME = "连接类型错误"; // 连接类型错误
    public static final String UNKNOW_ERROR_NAME = "未知异常"; // 未知异常
    public static final String PARSE_TEXT_NAME = "解析参数错误"; // 解析参数错误
    public static final String DATA_CONF_NAME = "数据库配置错误"; // 数据库配置错误
    public static final String GET_XML_ERROR_NAME = "返回报文错误"; // 返回报文错误
    public static final String GET_REDIS_ERROR_NAME = "获取redis异常"; // 获取redis异常
    public static final String OPER_REDIS_ERROR_NAME = "操作redis异常"; // set redis异常
    public static final String STAFF_STATUS_ERROR_NAME = "用户不在启用状态"; // 用户状态为异常
    public static final String PRIMARYKEY_EXCEPTION_NAME = "获取主键异常"; // 获取主键异常
    public static final String USER_PASSWORD_ERROR_NAME = "用户名密码错误！"; // 用户名密码错误
    public static final String USER_AGAINPASSWORD_ERROR_NAMW = "两次密码不一致"; // 两次密码不一致
    public static final String OPER_DELETE_FAILED_NAME = "无法删除"; // 删除时无法删除
    public static final String IS_TRUE_FLAG_NAME = "可用"; // 创建信息可用
    public static final String IS_FLASE_FLAG_NAME = "不可用"; // 创建信不息可用
    public static final String STAFF_STATUS_UNEXIST_NAME = "用户不存在"; // 用户不存在
    public static final String EXISTED_ANSWER_SHEET_NAME ="已存在报价清单，不能重复报价";//已存在报价清单，不能重复报价
    public static final String EXPORT_EXCEL_NAME ="导出内容到Excel时报错";//导出内容到Excel时报错
    public static final String SEQUENCE_GENERATE_ERROR_NAME ="Sequence生成主键Id时发生异常";//Sequence生成主键Id时发生异常
    public static final String DATE_FORMAT_ERROR_NAME ="日期转换异常";
    public static final String CODE_EXIST_ERROR_NAME ="编号已经存在";//编号已经存在
    public static final String OPEN_SEARCH_CLIENT_PROTOCOL_EXCEPTION_NAME = "OpenSearch客户端协议异常:未知主机异常！"; // OpenSearch客户端协议异常
    public static final String OPEN_SEARCH_UNKNOWN_HOST_EXCEPTION_NAME ="OpenSearch创建客户端时，未知主机异常";//OpenSearch创建客户端时，未知主机异常
    public static final String OPEN_SEARCH_IO_ERROR_NAME ="OpenSearch上传文档IO操作异常";//OpenSearch上传文档IO操作异常
    public static final String COMMODITY_NOT_EXIST_NAME ="商品不存在";//OpenSearch创建客户端时，未知主机异常
    public static final String SIGINST_IS_NULL_NAME ="单品信息为空，请添加单品";//OpenSearch创建客户端时，未知主机异常
    public static final String COMMODITY_DELETED_NAME ="商品已删除，无法上架";//OpenSearch创建客户端时，未知主机异常
    public static final String COMMODITY_UNSHELVED_NAME ="商品已下架，更新失败";//OpenSearch创建客户端时，未知主机异常
    public static final String COMMODITY_SHELVED_NAME ="商品已上架，更新失败";//OpenSearch创建客户端时，未知主机异常
    public static final String COMMODITY_DRAFT_NAME ="商品为未上架，更新失败";//OpenSearch创建客户端时，未知主机异常
    public static final String ENCRYPT_TEXT_NAME = "加密报文错误"; // 加密参数错误
}
