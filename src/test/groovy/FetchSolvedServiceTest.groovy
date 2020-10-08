import com.app.portfolio.Model.Aoj
import com.app.portfolio.Model.Stat

import com.app.portfolio.Service.FetchSolvedService
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class FetchSolvedServiceTest extends Specification{

    // テスト対象のクラス
    private static FetchSolvedService service;

    def setup(){
        service = new FetchSolvedService()
        service.restTemplate = Mock(RestTemplate)
    }

    def "AOJ"(){
        given:
            def AojEntity = new Aoj()
            AojEntity.with {
                setStatus(new Stat())
                status.setSolved(11111)
            }
        when:
            def retVal = service.getAojSolved()
        then:
            1 * service.restTemplate.getForObject(_, _) >> AojEntity
            retVal == 11111
    }
}
