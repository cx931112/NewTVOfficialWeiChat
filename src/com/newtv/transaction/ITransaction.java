package com.newtv.transaction;

public interface ITransaction
{
    public void beginTransaction();
    
    public void commit();
    
    public void rollback();
}
