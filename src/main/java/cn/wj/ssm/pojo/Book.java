package cn.wj.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer bookID;
    private String bookName;
    private Integer bookCounts;
    private String detail;
    
}