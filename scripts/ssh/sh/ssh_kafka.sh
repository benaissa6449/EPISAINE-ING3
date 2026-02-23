#!/bin/bash
USER = episaine
HOST = 172.31.249.144
PORT = 110

echo "Connecting to $USER@$HOST on port $PORT..."
ssh $USER@$HOST -p $PORT