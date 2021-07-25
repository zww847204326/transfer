package czbank.jiangjian.mapper;

import czbank.jiangjian.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface RecordMapper {

    Integer addRecord(Record record);

    List<Record> queryRecords(
            @Param("cardNum") String cardNum, @Param("startTime") String startTime,
            @Param("endTime") String endTime);

}
