/* 
 * Copyright 2018 The Exonum Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.exonum.binding.storage.indices;

import com.exonum.binding.storage.database.View;

/**
 * Storage index is a persistent, named collection built on top of Exonum key-value storage.
 *
 * <p>Also known as a collection, a table, and also as (rarely) a view for
 * a {@linkplain View database view} is inherently associated with an index.
 */
// todo: Document the various index types if this becomes public (ECR-595)
interface StorageIndex {

  /** Returns the name of this index. */
  String getName();
}
