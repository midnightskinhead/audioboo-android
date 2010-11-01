#! /bin/bash
#
# This file is part of AudioBoo, an android program for audio blogging.
# Copyright (C) 2009 BestBefore Media Ltd. All rights reserved.
#
# Author: Jens Finkhaeuser <jens@finkhaeuser.de>
#
# $Id: build-externals.sh 525 2009-10-07 14:53:16Z unwesen $

# 1. Build dnssjava
pushd externals/dnsjava >/dev/null
ant
cp *.jar ../../libs
popd >/dev/null
