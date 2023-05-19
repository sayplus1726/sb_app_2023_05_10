package com.sbs.exam.sb_app_2022_10_13.repository;

import com.sbs.exam.sb_app_2022_10_13.vo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleRepository {

  // INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = ?, `body` = ?
  @Insert("""
          INSERT INTO article
          SET regDate = NOW(),
          updateDate = NOW(),
          boardId = #{boardId},
          memberId = #{memberId},
          title = #{title},
          `body` = #{body}
          """)
  public void writeArticle(@Param("memberId") int memberId, @Param("boardId") int boardId, @Param("title") String title, @Param("body") String body);

  // SELECT * FROM article WHERE id = ?
  @Select("""
         SELECT A.*,
         M.nickname AS extra__writerName
         FROM article AS A
         LEFT JOIN member AS M
         ON A.memberId = M.id
         WHERE 1
         AND A.id = #{id}
         """)
  public Article getForPrintArticle(@Param("id") int id);

  // DELETE FROM article WHERE id = ?
  @Delete("""
          DELETE
          FROM article
          WHERE id = #{id}
          """)
  public void deleteArticle(int id);

  // SELECT * FROM article ORDER BY id DESC;
 @Select("""
         SELECT A.*,
         M.nickname AS extra__writerName
         FROM article AS A
         LEFT JOIN member AS M
         ON A.memberId = M.id
         ORDER BY A.id DESC
         """)
  public List<Article> getForPrintArticles();

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

  @Select("""
         <script>
         SELECT A.*,
         M.nickname AS extra__writerName
         FROM article AS A
         LEFT JOIN member AS M
         ON A.memberId = M.id
         WHERE 1
         <if test="boardId != 0">
            AND A.boardId = #{boardId}
         </if>
         ORDER BY A.id DESC
         <if test="limitTake != -1">
            LIMIT #{limitStart}, #{limitTake}
         </if>
         </script>
         """)
  public List<Article> getArticles(@Param("boardId") int boardId, @Param("limitStart") int limitStart, @Param("limitTake") int limitTake);

  @Select("""
         <script>
         SELECT COUNT(*) AS cnt
         FROM article AS A
         WHERE 1
         <if test="boardId != 0">
            AND A.boardId = #{boardId}
         </if>
         <if test="searchKeyword != ''">
            <choose>
                <when test="searchKeywordTypeCode == 'title'">
                    AND A.title LIKE CONCAT('%', #{searchKeyword}, '%')
                </when>
                <when test="searchKeywordTypeCode == 'body'">
                    AND A.body LIKE CONCAT('%', #{searchKeyword}, '%')
                </when>
                <otherwise>
                    AND (
                      A.title LIKE CONCAT('%', #{searchKeyword}, '%')
                      OR
                      A.body LIKE CONCAT('%', #{searchKeyword}, '%')
                    )
                </otherwise>
            </choose>
         </if>
         </script>
         """)
  public int getArticlesCount(@Param("boardId") int boardId, @Param("searchKeywordTypeCode") String searchKeywordTypeCode, @Param("searchKeyword") String searchKeyword);
}
