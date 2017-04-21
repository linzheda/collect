package com.zd.test;



import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zd.bean.Favorite;
import com.zd.bean.Tag;
import com.zd.dao.MyBatisHelper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
   
    public AppTest( String testName )
    {
        super( testName );
    }

    
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    public void testApps()
    {
        assertTrue( true );
    }

    public void testApp() throws Exception
    {
    	SqlSession s=MyBatisHelper.getSession();
    	List<Tag> list=s.selectList("com.zd.mapper.TagMapper.selectTagAll");
    	System.out.println(list);
    }
   
    public void testApp2() throws Exception
    {
    	SqlSession s=MyBatisHelper.getSession();
    	List<Favorite> list=s.selectList("com.zd.mapper.FavoriteMapper.selectFavoriteAll");
    	System.out.println(list);
    }
    public void testApp3() throws Exception
    {
    	SqlSession s=MyBatisHelper.getSession();
    	Tag t=s.selectOne("com.zd.mapper.TagMapper.selectTagByName","java");
    	System.out.println(t);
    }
    public void testApp4() throws Exception
    {
    	SqlSession s=MyBatisHelper.getSession();
    	Tag t=s.selectOne("com.zd.mapper.TagMapper.selectTagByName","java");
    	System.out.println(t);
    }
    
}
