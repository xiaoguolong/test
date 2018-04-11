import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Administrator on 2018/3/12.
 */

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Article {

    private Long id;
    private String title;
    private String content;
}