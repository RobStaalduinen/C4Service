package com.gameservice.data;

import java.io.IOException;

import com.gameservice.core.ConnectFourGame;
import com.gameservice.state.ErrorStatus;
import com.gameservice.state.Status;
import com.gameservice.state.StatusCodes;
import com.gameservice.utils.ObjectSerializer;

import redis.clients.jedis.Jedis;

/*
 * Allows game data to be stored in serialized form in a Redis database.
 * 
 * Not fully tested, but provides good proof of concept on storing ConnectFourGame objects
 * in a volatile data structure. Could be expanded to allow configurable access to store games
 * on a remote server
 * 
 */
public class RedisStore extends GameStore {
	
	private Jedis jedisMap;
	
	//Ideally would be configurable via application config file
	private final String serverLocation = "localhost";
	
	public RedisStore()
	{
		jedisMap = new Jedis(serverLocation);
	}
	
	@Override
	public Status createNewGameSession()
	{
		idIndex++;
		ConnectFourGame newGame = new ConnectFourGame(idIndex);
		Status creationStatus;
		try
		{
			byte[] idArray = ObjectSerializer.serialize(Integer.toString(idIndex));
			byte[] gameByteArray = ObjectSerializer.serialize(newGame);			
			jedisMap.set(idArray, gameByteArray);
			creationStatus = newGame.getGameStatus();
		}
		catch(IOException e)
		{
			creationStatus = new ErrorStatus(StatusCodes.CREATION_ERROR, "Error serializing game data for Redis DB.");
		}
		return creationStatus;
	}
	
	@Override
	public ConnectFourGame getGame(int id)
	{
		ConnectFourGame returnedGame = null;
		try
		{
			byte[] idArray = ObjectSerializer.serialize(Integer.toString(id));
			byte[] gameArray = jedisMap.get(idArray);
			returnedGame = (ConnectFourGame) ObjectSerializer.deserialize(gameArray);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		return returnedGame;
	}
}
