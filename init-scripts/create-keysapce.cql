CREATE KEYSPACE IF NOT EXISTS urls
  WITH REPLICATION = { 
   'class' : 'NetworkTopologyStrategy',
   'datacenter1' : 3 
  } 
AND DURABLE_WRITES = true ;