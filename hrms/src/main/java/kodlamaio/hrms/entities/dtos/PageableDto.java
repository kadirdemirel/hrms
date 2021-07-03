package kodlamaio.hrms.entities.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class PageableDto<T> {
	

	private int pageNo;
	private int pageSize;
	private int section;
	private T listData;
}
