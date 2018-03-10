package tower_service;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.tydic.base.util.DateUtils;
import com.tydic.base.vo.JSONResult;
import com.tydic.bo.NodeBO;
import com.tydic.bo.SensorDailyCunsumpParamBO;
import com.tydic.bo.TelOperatorBO;
import com.tydic.service.BusinessService;

@ContextConfiguration(locations = { "classpath*:test-applicationContext-db-user.xml",
        "classpath*:test-applicationContext-service-user.xml" })
public class TestService extends AbstractJUnit4SpringContextTests {
    @Autowired
    private BusinessService businessService;

    @Test
    public void test() {
        SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO = new SensorDailyCunsumpParamBO();
        sensorDailyCunsumpParamBO.setStartTime(DateUtils.formatDate("2017-12-01", DateUtils.DATE_DEFAULT_FORMAT));
        sensorDailyCunsumpParamBO.setEndTime(DateUtils.formatDate("2017-12-11", DateUtils.DATE_DEFAULT_FORMAT));
        JSONResult<Map<NodeBO, Map<TelOperatorBO, Double>>> json = businessService.queryNodeMap(sensorDailyCunsumpParamBO);
        System.out.println(json.getData());
    }
}
