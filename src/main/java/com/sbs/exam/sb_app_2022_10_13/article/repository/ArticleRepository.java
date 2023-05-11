package com.sbs.exam.sb_app_2022_10_13.article.repository;

import com.sbs.exam.sb_app_2022_10_13.article.vo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleRepository {

  // INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = ?, `body` = ?
  @Insert("""
          INSERT INTO article
          SET regDate = NOW(),
          updateDate = NOW(),
          title = #{title},
          `body` = #{body}"
          """)
  public void writeArticle(@Param("title") String title, @Param("body") String body);

  // SELECT * FROM article WHERE id = ?
  @Select("""
          SELECT *
          FROM article
          WHERE id = #{id}
          """)
  public Article getArticle(@Param("id") int id);

  // DELETE FROM article WHERE id = ?
  @Delete("""
          DELETE
          FROM article
          WHERE id = #{id}
          """)
  public void deleteArticle(int id);

  // SELECT * FROM article ORDER BY id DESC;
 @Select("""
         SELECT *
         FROM article
         ORDER BY id DESC
         """)
  public List<Article> getArticles();

  // UPDATE article SET title = ?, `body` = ?, updateDate = NOW() WHERE id = ?
  @Update("""
          <script>
          UPDATE article
          <set>
            <if test='title != null'>
             title = #{title},
            </if>
            <if test='body != null'>
             `body` = #{body},
            </if>
           updateDate = NOW()
          </set>
          WHERE id = #{id}
          </script>
          """)
  public void modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);

  @Select("SELECT LAST_INSERT_ID()")
  public int getLastInsertId();
}
