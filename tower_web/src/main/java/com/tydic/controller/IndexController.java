package com.tydic.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tydic.base.constant.ConstantCodeDefine;
import com.tydic.base.entity.OperCodeDefine;
import com.tydic.base.exception.PurchaseException;
import com.tydic.base.util.ApplicationUtils;
import com.tydic.base.util.DateUtils;
import com.tydic.base.vo.JSONResult;
import com.tydic.base.vo.RespObjVO;
import com.tydic.bo.MenuBO;
import com.tydic.bo.NodeBO;
import com.tydic.bo.NodeParamBO;
import com.tydic.bo.SensorBO;
import com.tydic.bo.SensorDailyCunsumpBO;
import com.tydic.bo.SensorDailyCunsumpParamBO;
import com.tydic.bo.SensorParamBO;
import com.tydic.bo.SensorValuesDailyShowBO;
import com.tydic.bo.SensorValuesParamBO;
import com.tydic.bo.SensorValuesShowBO;
import com.tydic.bo.TelOperatorBO;
import com.tydic.bo.TelOperatorParamBO;
import com.tydic.service.BusinessService;
import com.tydic.util.ManageUtils;

import jxl.Workbook;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/")
public class IndexController {
    private BusinessService businessService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, ModelMap map) {
        // 图表
        String startTimeStr = request.getParameter("startTimeStr");
        String endTimeStr = request.getParameter("endTimeStr");
        Date startTime = null;
        Date endTime = null;
        if (startTimeStr == null || startTimeStr.equals("")) {
            startTime = DateUtils.formatDate(DateUtils.getFirstDayOfCurentMounth(), DateUtils.DATE_DEFAULT_FORMAT);
        } else {
            startTime = DateUtils.formatDate(startTimeStr, DateUtils.DATE_DEFAULT_FORMAT);
            map.put("startTime", startTimeStr);
        }
        if (endTimeStr == null || endTimeStr.equals("")) {
            String endTimeTempStr = DateUtils.getDateFormat(new Date());
            endTime = DateUtils.formatDate(endTimeTempStr, DateUtils.DATE_DEFAULT_FORMAT);
        } else {
            endTime = DateUtils.formatDate(endTimeStr, DateUtils.DATE_DEFAULT_FORMAT);
            map.put("endTime", endTimeStr);
        }

        SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO = new SensorDailyCunsumpParamBO();
        sensorDailyCunsumpParamBO.setStartTime(startTime);
        sensorDailyCunsumpParamBO.setEndTime(endTime);
        JSONResult<SensorValuesDailyShowBO> jsonDailyShow = businessService
                .queryChartSensorValueDailyShow(sensorDailyCunsumpParamBO);
        if (jsonDailyShow.getData() != null) {
            JSONArray chartDayShowArrayStr = JSONArray.fromObject(jsonDailyShow.getData().getChartDayList());
            map.put("chartDayShowArrayStr", chartDayShowArrayStr.toString().replaceAll("\"", "'"));
            JSONArray chartElecDianShowArrayStr = JSONArray.fromObject(jsonDailyShow.getData().getChartElecDianList());
            map.put("chartElecDianShowArrayStr", chartElecDianShowArrayStr.toString().replaceAll("\"", ""));
            JSONArray chartElecLianShowArrayStr = JSONArray.fromObject(jsonDailyShow.getData().getChartElecLianList());
            map.put("chartElecLianShowArrayStr", chartElecLianShowArrayStr.toString().replaceAll("\"", ""));
            JSONArray chartElecYiShowArrayStr = JSONArray.fromObject(jsonDailyShow.getData().getChartElecYiList());
            map.put("chartElecYiShowArrayStr", chartElecYiShowArrayStr.toString().replaceAll("\"", ""));
            map.put("chartElecDianSum", jsonDailyShow.getData().getChartElecDianSum());
            map.put("chartElecLianSum", jsonDailyShow.getData().getChartElecLianSum());
            map.put("chartElecYiSum", jsonDailyShow.getData().getChartElecYiSum());
            map.put("elecSum", jsonDailyShow.getData().getElecSum());
        }

        MenuBO menu = (MenuBO) ManageUtils.getSessionValue("menu");
        if (menu == null) {
            return "redirect:/rest/user/logout";
        }
        map.put("nodeBOList", menu.getNodeBOList());

        return "index";
    }

    @RequestMapping("/main")
    public String main(HttpServletRequest request, ModelMap map) {
        String nodecode = request.getParameter("nodecode");
        if (nodecode == null || nodecode.equals("")) {
            return "redirect:/rest/index";
        }
        NodeParamBO nodeParamBO = new NodeParamBO();
        nodeParamBO.setNodecode(nodecode);
        nodeParamBO.setPageIndex(1);
        nodeParamBO.setPageSize(10);
        JSONResult<List<NodeBO>> jsonNode = businessService.queryNodeList(nodeParamBO);
        if (jsonNode.getData().size() == 0) {
            return "redirect:/rest/index";
        }
        map.put("nodecode", nodecode);
        map.put("nodename", jsonNode.getData().get(0).getNodename());
        String startTimeStr = request.getParameter("startTimeStr");
        String endTimeStr = request.getParameter("endTimeStr");
        Date startTime = null;
        Date endTime = null;
        if (startTimeStr == null || startTimeStr.equals("")) {
            startTime = DateUtils.formatDate(DateUtils.getFirstDayOfCurentMounth(), DateUtils.DATE_DEFAULT_FORMAT);
        } else {
            startTime = DateUtils.formatDate(startTimeStr, DateUtils.DATE_DEFAULT_FORMAT);
            map.put("startTime", startTimeStr);
        }
        if (endTimeStr == null || endTimeStr.equals("")) {
            String endTimeTempStr = DateUtils.getDateFormat(new Date());
            endTime = DateUtils.formatDate(endTimeTempStr, DateUtils.DATE_DEFAULT_FORMAT);
        } else {
            endTime = DateUtils.formatDate(endTimeStr, DateUtils.DATE_DEFAULT_FORMAT);
            map.put("endTime", endTimeStr);
        }
        SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO = new SensorDailyCunsumpParamBO();
        sensorDailyCunsumpParamBO.setStartTime(startTime);
        sensorDailyCunsumpParamBO.setEndTime(endTime);
        sensorDailyCunsumpParamBO.setNodecode(nodecode);
        JSONResult<SensorValuesDailyShowBO> jsonDailyShow = businessService
                .queryChartSensorValueDailyShow(sensorDailyCunsumpParamBO);
        if (jsonDailyShow.getData() != null) {
            JSONArray chartDayShowArrayStr = JSONArray.fromObject(jsonDailyShow.getData().getChartDayList());
            map.put("chartDayShowArrayStr", chartDayShowArrayStr.toString().replaceAll("\"", "'"));
            JSONArray chartElecDianShowArrayStr = JSONArray.fromObject(jsonDailyShow.getData().getChartElecDianList());
            map.put("chartElecDianShowArrayStr", chartElecDianShowArrayStr.toString().replaceAll("\"", ""));
            JSONArray chartElecLianShowArrayStr = JSONArray.fromObject(jsonDailyShow.getData().getChartElecLianList());
            map.put("chartElecLianShowArrayStr", chartElecLianShowArrayStr.toString().replaceAll("\"", ""));
            JSONArray chartElecYiShowArrayStr = JSONArray.fromObject(jsonDailyShow.getData().getChartElecYiList());
            map.put("chartElecYiShowArrayStr", chartElecYiShowArrayStr.toString().replaceAll("\"", ""));
            map.put("chartElecDianSum", jsonDailyShow.getData().getChartElecDianSum());
            map.put("chartElecLianSum", jsonDailyShow.getData().getChartElecLianSum());
            map.put("chartElecYiSum", jsonDailyShow.getData().getChartElecYiSum());
            map.put("elecSum", jsonDailyShow.getData().getElecSum());
        }

        MenuBO menu = (MenuBO) ManageUtils.getSessionValue("menu");
        if (menu == null) {
            return "redirect:/rest/user/logout";
        }
        map.put("nodeBOList", menu.getNodeBOList());
        return "main";
    }

    @RequestMapping("/detailed")
    public String detailed(HttpServletRequest request, ModelMap map) {
        String nodecode = request.getParameter("nodecode");
        String sensorname = request.getParameter("sensorname");
        String endTimeStr = request.getParameter("endTimeStr");
        if (nodecode == null || nodecode.equals("")) {
            return "redirect:/rest/index";
        }
        if (sensorname == null || sensorname.equals("")) {
            return "redirect:/rest/index";
        }
        NodeParamBO nodeParamBO = new NodeParamBO();
        nodeParamBO.setNodecode(nodecode);
        nodeParamBO.setPageIndex(1);
        nodeParamBO.setPageSize(10);
        JSONResult<List<NodeBO>> jsonNode = businessService.queryNodeList(nodeParamBO);
        if (jsonNode.getData().size() == 0) {
            return "redirect:/rest/index";
        }
        map.put("nodecode", nodecode);
        map.put("nodename", jsonNode.getData().get(0).getNodename());
        SensorParamBO sensorParamBO = new SensorParamBO();
        sensorParamBO.setSensorname(sensorname);
        JSONResult<List<SensorBO>> jsonSensor = businessService.querySensorList(sensorParamBO);
        if (jsonSensor.getData().size() == 0) {
            return "redirect:/rest/index";
        }
        map.put("sensorname", sensorname);
        TelOperatorParamBO telOperatorParamBO = new TelOperatorParamBO();
        telOperatorParamBO.setTeloperatorId(jsonSensor.getData().get(0).getTeloperatorid());
        JSONResult<List<TelOperatorBO>> jsonTelOperator = businessService.queryTeloperatorList(telOperatorParamBO);
        if (jsonTelOperator.getData().size() == 0) {
            return "redirect:/rest/index";
        }
        map.put("teloperatorname", jsonTelOperator.getData().get(0).getName());

        Date startTime = null;
        Date endTime = null;
        if (endTimeStr == null || endTimeStr.equals("")) {
            endTime = new Date();
            String startTimeStr = DateUtils.getDateFormat(endTime, DateUtils.DATE_DEFAULT_FORMAT) + " 00:00:00:000";
            startTime = DateUtils.formatDate(startTimeStr, DateUtils.DATETIME_DEFAULT_FORMAT_SMALL);
        } else {
            endTime = DateUtils.formatDate(endTimeStr + " 23:59:59:999", DateUtils.DATETIME_DEFAULT_FORMAT_SMALL);
            startTime = DateUtils.formatDate(endTimeStr + " 00:00:00:000", DateUtils.DATETIME_DEFAULT_FORMAT_SMALL);
            map.put("endTime", endTimeStr);
        }
        SensorValuesParamBO sensorValuesParamBO = new SensorValuesParamBO();
        sensorValuesParamBO.setStartTime(startTime);
        sensorValuesParamBO.setEndTime(endTime);
        sensorValuesParamBO.setNodecode(nodecode);
        sensorValuesParamBO.setSensorname(sensorname);
        JSONResult<SensorValuesShowBO> json = businessService.queryChartSensorValueShow(sensorValuesParamBO);
        if (json.getData() != null) {
            JSONArray chartHourShowArrayStr = JSONArray.fromObject(json.getData().getChartHourList());
            map.put("chartHourShowArrayStr", chartHourShowArrayStr.toString().replaceAll("\"", "'"));
            JSONArray chartElectricityShowArrayStr = JSONArray.fromObject(json.getData().getChartElectricityList());
            map.put("chartElectricityShowArrayStr", chartElectricityShowArrayStr.toString().replaceAll("\"", ""));

        }
        MenuBO menu = (MenuBO) ManageUtils.getSessionValue("menu");
        if (menu == null) {
            return "redirect:/rest/user/logout";
        }
        map.put("nodeBOList", menu.getNodeBOList());

        return "detailed";
    }

    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult<List<SensorDailyCunsumpBO>> queryIndexList(HttpServletRequest request,
            SensorDailyCunsumpParamBO searchCondition) {
        String startTimeStr = searchCondition.getStartTimeStr();
        String endTimeStr = searchCondition.getEndTimeStr();
        Date startTime = null;
        Date endTime = null;
        if (startTimeStr == null || startTimeStr.equals("")) {
            startTime = DateUtils.formatDate(DateUtils.getFirstDayOfCurentMounth(), DateUtils.DATE_DEFAULT_FORMAT);
        } else {
            startTime = DateUtils.formatDate(startTimeStr, DateUtils.DATE_DEFAULT_FORMAT);
        }
        if (endTimeStr == null || endTimeStr.equals("")) {
            String endTimeTempStr = DateUtils.getDateFormat(new Date());
            endTime = DateUtils.formatDate(endTimeTempStr, DateUtils.DATE_DEFAULT_FORMAT);
        } else {
            endTime = DateUtils.formatDate(endTimeStr, DateUtils.DATE_DEFAULT_FORMAT);
        }
        if (StringUtils.isEmpty(searchCondition.getPageIndex())) {
            searchCondition.setPageIndex(1);
        } else {
            searchCondition.setPageIndex(searchCondition.getPageIndex());
        }
        if (StringUtils.isEmpty(searchCondition.getPageSize())) {
            searchCondition.setPageSize(10);
        }
        searchCondition.setStartTime(startTime);
        searchCondition.setEndTime(endTime);
        JSONResult<List<SensorDailyCunsumpBO>> json = businessService
                .queryChartSensorValueDailyByParam(searchCondition);
        for (int i = 0; i < json.getData().size(); i++) {
            SensorDailyCunsumpBO sensorDailyCunsumpBO = json.getData().get(i);
            sensorDailyCunsumpBO.setChargedayshow(DateUtils.getDateFormat(sensorDailyCunsumpBO.getChargeday()));
        }

        return json;
    }

    @RequestMapping(value = "/queryElCunsump", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult<Double> queryElCunsump(HttpServletRequest request, SensorDailyCunsumpParamBO searchCondition) {
        Double resultElcunsump = 0.00;
        JSONResult<Double> json = new JSONResult<>();
        String calTimeStr = searchCondition.getCalTimeStr();
        String sensorname = searchCondition.getSensorname();
        Date chargeday = null;
        if (calTimeStr == null || calTimeStr.equals("")) {
            json.setData(0.00);
            json.setSuccess(true);
            return json;
        } else {
            chargeday = DateUtils.formatDate(calTimeStr, DateUtils.DATE_DEFAULT_FORMAT);
            searchCondition.setChargeday(chargeday);
        }
        if (sensorname == null || sensorname.equals("")) {
            json.setData(0.00);
            json.setSuccess(true);
            return json;
        }
        searchCondition.setPageIndex(1);
        searchCondition.setPageSize(10);
        JSONResult<List<SensorDailyCunsumpBO>> jsonResult = businessService
                .queryChartSensorValueDailyByParam(searchCondition);
        if (jsonResult.getData().size() > 0) {
            resultElcunsump = jsonResult.getData().get(0).getElcunsump();
        } else {
            json.setData(0.00);
            json.setSuccess(true);
            return json;
        }
        json.setData(resultElcunsump);
        json.setSuccess(true);
        return json;
    }

    @RequestMapping(value = "/exportReport", method = RequestMethod.POST)
    @ResponseBody
    public RespObjVO exportReport(HttpServletRequest request, SensorDailyCunsumpParamBO searchCondition) {
        RespObjVO result = new RespObjVO();
        String startTimeStr = searchCondition.getStartTimeStr();
        String endTimeStr = searchCondition.getEndTimeStr();
        Date startTime = null;
        Date endTime = null;
        if (startTimeStr == null || startTimeStr.equals("")) {
            startTime = DateUtils.formatDate(DateUtils.getFirstDayOfCurentMounth(), DateUtils.DATE_DEFAULT_FORMAT);
            startTimeStr = DateUtils.getFirstDayOfCurentMounth();
        } else {
            startTime = DateUtils.formatDate(startTimeStr, DateUtils.DATE_DEFAULT_FORMAT);
        }
        if (endTimeStr == null || endTimeStr.equals("")) {
            String endTimeTempStr = DateUtils.getDateFormat(new Date());
            endTime = DateUtils.formatDate(endTimeTempStr, DateUtils.DATE_DEFAULT_FORMAT);
            endTimeStr = endTimeTempStr;
        } else {
            endTime = DateUtils.formatDate(endTimeStr, DateUtils.DATE_DEFAULT_FORMAT);
        }
        searchCondition.setPageIndex(1);
        // 最多两千条
        searchCondition.setPageSize(2000);
        searchCondition.setStartTime(startTime);
        searchCondition.setEndTime(endTime);
        JSONResult<List<SensorDailyCunsumpBO>> json = businessService
                .queryChartSensorValueDailyByParam(searchCondition);
        String fileName = "电量统计表";
        String destFilePath = getExcelExportFile(request, fileName);
        WritableWorkbook wwb = null;
        OutputStream os = null;
        try {
            os = new FileOutputStream(destFilePath);
        } catch (FileNotFoundException e) {
            throw new PurchaseException("创建文件输出流异常", "创建文件输出流异常", e);
        }
        try {
            wwb = Workbook.createWorkbook(os);
        } catch (IOException e) {
            throw new PurchaseException("创建Excel工作薄异常", "创建Excel工作薄异常", e);
        }

        try {
            WritableSheet sheet = wwb.createSheet("sheet1", 0);
            Label label = null;
            String[] title = { "编号", "传感器", "所属单位", "基站名称", "用电日期", "用电数量（千瓦）" };
            for (int i = 0; i < title.length; i++) {
                sheet.setColumnView(i, 15);
                label = new Label(i, 0, title[i]);
                sheet.addCell(label);
            }
            // 计算各基站的各运营商的电量总和
            for (int i = 0; i < json.getData().size(); i++) {
                label = new Label(0, i + 1, i + "");
                sheet.addCell(label);
                label = new Label(1, i + 1, json.getData().get(i).getSensorname());
                sheet.addCell(label);
                label = new Label(2, i + 1, json.getData().get(i).getTeloperatorname());
                sheet.addCell(label);
                label = new Label(3, i + 1, json.getData().get(i).getNodename());
                sheet.addCell(label);
                label = new Label(4, i + 1, DateUtils.getDateFormat(json.getData().get(i).getChargeday()));
                sheet.addCell(label);
                label = new Label(5, i + 1, json.getData().get(i).getElcunsump().toString());
                sheet.addCell(label);
            }
            // 设置单元格垂直居中
            WritableCellFormat cellFormat = new WritableCellFormat();
            cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
            // 编辑行开始位置
            int rowRosition = 0;
            sheet.setColumnView(7, 15);
            sheet.setColumnView(8, 15);
            sheet.setColumnView(9, 15);
            sheet.setColumnView(10, 15);
            sheet.setColumnView(11, 15);
            // 日期
            label = new Label(7, 0, "日期区间");
            sheet.addCell(label);
            label = new Label(8, 0, startTimeStr);
            sheet.addCell(label);
            label = new Label(9, 0, "至");
            sheet.addCell(label);
            label = new Label(10, 0, endTimeStr);
            sheet.addCell(label);
            rowRosition = rowRosition + 2;
            // 计算总数
            BigDecimal sumElect = new BigDecimal(0.00);
            JSONResult<Map<NodeBO, Map<TelOperatorBO, Double>>> jsonNodeMap = businessService
                    .queryNodeMap(searchCondition);
            for (Map.Entry<NodeBO, Map<TelOperatorBO, Double>> entry : jsonNodeMap.getData().entrySet()) {
                NodeBO nodeBO = entry.getKey();
                Map<TelOperatorBO, Double> mapInner = entry.getValue();
                sheet.mergeCells(7, rowRosition, 7, rowRosition + 2);
                label = new Label(7, rowRosition, nodeBO.getNodename());
                label.setCellFormat(cellFormat);
                sheet.addCell(label);
                BigDecimal sumElectInner = new BigDecimal(0.00);
                int telCountInner = 0;
                for (Map.Entry<TelOperatorBO, Double> entryInner : mapInner.entrySet()) {
                    TelOperatorBO telOperatorBO = entryInner.getKey();
                    Double elect = entryInner.getValue();
                    label = new Label(8, rowRosition + telCountInner, telOperatorBO.getName());
                    sheet.addCell(label);
                    label = new Label(9, rowRosition + telCountInner, elect.toString() + "千瓦");
                    sheet.addCell(label);
                    sumElectInner = sumElectInner.add(new BigDecimal(Double.toString(elect)));
                    telCountInner++;
                }
                label = new Label(10, rowRosition + telCountInner, sumElectInner.toString() + "千瓦");
                sheet.addCell(label);
                sumElect = sumElect.add(sumElectInner);
                sumElectInner = new BigDecimal(0.00);
                rowRosition = rowRosition + telCountInner + 1;
            }
            if (jsonNodeMap.getData().size() > 1) {
                label = new Label(7, rowRosition, "总量");
                sheet.addCell(label);
                label = new Label(11, rowRosition, sumElect.toString() + "千瓦");
                sheet.addCell(label);
            }
        } catch (RowsExceededException e) {
            throw new PurchaseException("创建单元格异常", "创建单元格异常", e);
        } catch (WriteException e) {
            throw new PurchaseException("写单元格异常", "写单元格异常", e);
        }
        try {
            wwb.write();
        } catch (IOException e) {
            throw new PurchaseException("excel写入流异常", "excel写入流异常", e);
        }
        try {
            wwb.close();
        } catch (WriteException e) {
            throw new PurchaseException("excel写入流关闭异常", "excel写入流关闭异常", e);
        } catch (IOException e) {
            throw new PurchaseException("excel写入流关闭异常", "excel写入流关闭异常", e);
        }
        result.setRespDesc(destFilePath);
        result.setSuccess(true);
        return result;
    }

    @RequestMapping("/exportDownload")
    @ResponseBody
    public void explortExcelResut(HttpServletRequest request, HttpServletResponse response, String filePath) {
        ServletContext context = request.getServletContext();
        File downloadFile = new File(filePath);
        FileInputStream inputStream = null;
        OutputStream outStream = null;
        try {
            inputStream = new FileInputStream(downloadFile);

            // get MIME type of the file
            String mimeType = context.getMimeType(downloadFile.getName());
            if (mimeType == null) {
                // set to binary type if MIME mapping not found
                mimeType = "application/octet-stream";
            }

            // set content attributes for the response
            response.setContentType(mimeType);
            response.setContentLength((int) downloadFile.length());

            // set headers for the response
            String headerKey = "Content-Disposition";
            String headerValue;
            headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
            response.setHeader(headerKey, headerValue);

            // get output stream of the response
            outStream = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            // write bytes read from the input stream into the output stream
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            throw new PurchaseException(OperCodeDefine.FILE_NOT_FOUND, e.getMessage());
        } catch (IOException e) {
            throw new PurchaseException(OperCodeDefine.FILE_DOWNLOAD_ERROR, e.getMessage());
        } finally {
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
            }
            if (outStream != null) {
                IOUtils.closeQuietly(outStream);
            }
        }

    }

    public String getExcelExportFile(HttpServletRequest request, String fileName) {
        try {
            fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        // 获取临时目录根路径
        ServletContext context = request.getServletContext();
        String webRootPath = context.getRealPath("/");
        // 缓存路径文件夹
        String dateDir = DateUtils.getDateFormatOther(DateUtils.getNowDate(), "yyyyMMdd");
        String tempPath = ConstantCodeDefine.UPLOAD_TEMP_DIR + dateDir;
        File tempDir = new File(webRootPath + tempPath);

        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }
        String desFileName = (fileName != null && fileName.equals("")) ? fileName : ApplicationUtils.randomUUID();
        File webTempFile = new File(webRootPath + tempPath, desFileName + ".xls");
        return webTempFile.getAbsolutePath();
    }

    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }

}
